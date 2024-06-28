package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.utils.RedisIdWorker;
import com.hmdp.utils.SimpleRedisLock;
import com.hmdp.utils.UserHolder;
import org.springframework.aop.framework.AopContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {
	@Resource
	private ISeckillVoucherService seckillVoucherService;

	@Resource
	private RedisIdWorker redisIdWorker;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public Result seckillVoucher(Long voucherId) {
		//查询优惠券
		SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
		//判断秒杀是否开始
		if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
			return Result.fail("秒杀尚未开始");
		}
		//判断秒杀是否已经结束
		if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
			return Result.fail("秒杀已经结束");
		}
		//判断库存是否充足
		if (voucher.getStock() < 1) {
			return Result.fail("库存不足");
		}

		Long userId = UserHolder.getUser().getId();
		//TODO 事务 锁 事务失效 动态代理 锁的范围
		//由于 锁 在事务内部，在锁释放到事务提交之间，会有并发问题
		//所以这里需要将整个方法锁起来，在事务提交完毕，才会释放锁
		//事务问题：只对createVoucher()加事务，没有对seckillVoucher()加事务
		//this.createVoucher() this（可以省略）指的是VoucherOrderServiceImpl对象
		//而不是VoucherOrderServiceImpl的代理对象
		//而spring作事务处理，是拿到VoucherOrderServiceImpl的代理对象，进行事务管理
		//所以this没有事务功能（事务失效的几种可能性之一）
		//这里需要引入依赖
		//        <!--动态代理-->
		//        <dependency>
		//            <groupId>org.aspectj</groupId>
		//            <artifactId>aspectjweaver</artifactId>
		//        </dependency>
		//同时启动类中加入注解，暴露这个代理对象：@EnableAspectJAutoProxy(exposeProxy=true)

		//保证是同一个用户才加锁，不同的用户使用不同的锁
		//toString()返回的是新的String对象
		//.intern() 返回字符串对象的规范表示，如果池中包含一个等于该String对象的字符串，返回池中的字符串

		//这把锁在多JVM下，不同进程的线程之间会失效
		//synchronized (userId.toString().intern()) {
		//	//获取VoucherOrderServiceImpl的代理对象
		//	IVoucherOrderService proxy = (IVoucherOrderService)AopContext.currentProxy();
		//	//return this.createVoucher(voucherId);
		//	//调用代理对象的createVoucher()方法
		//	return proxy.createVoucher(voucherId);
		//}

		//使用redis的setnx，互斥
		//1.setnx lock islock  获取锁
		//2.expire lock 5  （避免服务出现问题导致锁一直存在）
		//3.del lock  释放锁
		//1 2必须要原子性，否则会出现获取锁后，服务失效，锁一直存在
		//改进：set lock islock nx ex 10
		//创建锁对象
		SimpleRedisLock lock = new SimpleRedisLock(stringRedisTemplate, "order" + userId);
		//获取锁
		boolean isLock = lock.tryLock(1200L);
		if(!isLock) {//获取锁失败
			//返回失败信息，或者重试，这里因为是一人一单，所以不应该重试
			return Result.fail("不允许重复下单");
		}
		try {
			IVoucherOrderService proxy = (IVoucherOrderService) AopContext.currentProxy();
			return proxy.createVoucher(voucherId);
		} finally {
			lock.unlock();
		}
	}

	@Transactional
	public Result createVoucher(Long voucherId) {
		//一人一单
		Long userId = UserHolder.getUser().getId();
		//查询订单
		Integer count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
		//判断是否存在
		if (count > 0) {
			//用户已经够买过
			return Result.fail("用户已经购买过");
		}

		//扣减库存
		boolean success = seckillVoucherService.update()
				//set stock = stock - 1
				.setSql("stock = stock - 1")
				//where voucher_id = ? and stock = ?
				.eq("voucher_id", voucherId)
				//乐观锁：使用库存代替版本号，如果库存没变，说明在此期间没有别的线程修改库存，本线程可以进行操作
				//不会出现超卖，但是会少买
				//.eq("stock", voucher.getStock())
				//只要库存大于0，可以进行操作
				.gt("stock", 0)
				.update();
		if (!success) {
			return Result.fail("库存不足");
		}

		//创建订单
		VoucherOrder voucherOrder = new VoucherOrder();
		//订单id
		Long orderId = redisIdWorker.nextId("order");
		voucherOrder.setId(orderId);
		//用户id
		voucherOrder.setUserId(userId);
		//优惠券id
		voucherOrder.setVoucherId(voucherId);
		//订单写入数据库
		save(voucherOrder);
		//返回订单id
		return Result.ok(orderId);
	}
}
