package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.utils.RedisIdWorker;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {
	@Resource
	private ISeckillVoucherService seckillVoucherService;

	@Resource
	private RedisIdWorker redisIdWorker;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Resource
	private RedissonClient redissonClient;

	private static final DefaultRedisScript<Long> SECKILL_SCRIPT;
	static {
		SECKILL_SCRIPT = new DefaultRedisScript<>();
		SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
		SECKILL_SCRIPT.setResultType(Long.class);
	}

	//阻塞队列
	private final BlockingQueue<VoucherOrder> orderTasks = new ArrayBlockingQueue<>(1024 * 1024);
	//线程池
	private static final ExecutorService SECKILL_ORDER_EXECUTOR = Executors.newSingleThreadExecutor();

	@PostConstruct//bean构造注入完毕，初始化方法执行前执行
	private void init() {
		SECKILL_ORDER_EXECUTOR.submit(new VoucherOrderHandler());
	}

	public class VoucherOrderHandler implements Runnable {
		//执行业务逻辑
		@Override
		public void run() {
			while (true) {
				try {
					//获取队列中的订单信息
					VoucherOrder voucherOrder = orderTasks.take();
					//创建订单
					handleVoucherOrder(voucherOrder);
				} catch (InterruptedException e) {
					log.error("处理订单异常", e);
				}
			}
		}
	}

	private void handleVoucherOrder(VoucherOrder voucherOrder) {
		//这里是多线程，所以无法从ThreadLocal中获取用户信息
		Long userId = voucherOrder.getUserId();
		//使用redisson获取锁
		RLock lock = redissonClient.getLock("lock:order:" + userId);
		boolean isLock = lock.tryLock();
		if (!isLock) {//获取锁失败
			log.error("不允许重复下单{}", userId);
			return ;
		}
		try {
			proxy.createVoucher(voucherOrder);
		} finally {
			lock.unlock();
		}

	}

	private IVoucherOrderService proxy;

	@Override
	public Result seckillVoucher(Long voucherId) throws InterruptedException {
		//获取用户
		Long userId = UserHolder.getUser().getId();
		//1.执行lua脚本
		Long result = stringRedisTemplate.execute(SECKILL_SCRIPT,
				Collections.emptyList(),
				voucherId.toString(),
				userId.toString());
		//2.判断结果是否为0
		int re = 0;
		if (result != null) {
			re = result.intValue();
		}
		if(re != 0) {
			//2.1不为0，没有购买资格
			return Result.fail(re == 1 ? "库存不足" : "不能重复下单");
		}
		//2.2为0，有购买资格，将下单信息保存到阻塞队列
		VoucherOrder voucherOrder = new VoucherOrder();
		//2.3订单id
		long orderId = redisIdWorker.nextId("order");
		voucherOrder.setId(orderId);
		//2.4用户id
		voucherOrder.setUserId(userId);
		//2.5代金券id
		voucherOrder.setVoucherId(voucherId);
		//2.6放入阻塞队列
		orderTasks.add(voucherOrder);
		//获取代理对象
		proxy = (IVoucherOrderService) AopContext.currentProxy();
		//3.返回订单id
		return Result.ok(orderId);
	}
/*	@Override
	public Result seckillVoucher(Long voucherId) throws InterruptedException {
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
		//特性：
		//  利用setnx保证互斥性
		//  利用setnx保证故障时锁依然可以释放，避免死锁，提高安全性
		//  利用redis集群保证高可用和高并发特性
		//缺陷：
		//  不可重入；同一个线程无法多次获取同一把锁
		//  不可重试：获取锁只尝试一次就返回false，没有重试机制
		//  超时释放：如果业务执行时间较长，会导致锁释放，有安全隐患
		//  主从一致性：如果redis提供了主从集群，主从同步存在延时，主机宕机时，从机未同步主机数据，导致锁失效
		//1.setnx lock islock  获取锁
		//2.expire lock 5  （避免服务出现问题导致锁一直存在）
		//3.del lock  释放锁
		//1 2必须要原子性，否则会出现获取锁后，服务失效，锁一直存在
		//改进：set lock islock nx ex 10
		//创建锁对象
		//SimpleRedisLock lock = new SimpleRedisLock(stringRedisTemplate, "order" + userId);
		//获取锁
		//boolean isLock = lock.tryLock(1200L);

		//使用redisson获取锁
		RLock lock = redissonClient.getLock("lock:order:" + userId);
		//1:获取锁的最大等待时间（期间会重试），默认-1，不重试；
		//10:锁的自动释放时间；默认30s
		//时间单位
		//boolean isLock = lock.tryLock(1, 10, TimeUnit.SECONDS);
		boolean isLock = lock.tryLock();
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
	}*/

/*	@Transactional
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
	}*/

	@Transactional
	public void createVoucher(VoucherOrder voucherOrder) {
		Long userId = voucherOrder.getUserId();
		Integer count = query().eq("user_id", userId).eq("voucher_id", voucherOrder).count();
		if (count > 0) {
			log.error("{}用户已经购买过", userId);
			return ;
		}

		//扣减库存
		boolean success = seckillVoucherService.update()
				.setSql("stock = stock - 1")
				.eq("voucher_id", voucherOrder.getVoucherId())
				.gt("stock", 0)
				.update();
		if (!success) {
			log.error("{}库存不足", userId);
			return ;
		}

		//订单写入数据库
		save(voucherOrder);
	}
}
