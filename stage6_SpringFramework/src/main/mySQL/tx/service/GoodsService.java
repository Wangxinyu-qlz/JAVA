package main.mySQL.tx.service;

import main.mySQL.tx.dao.GoodsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-24 10:14
 * @description:
 **/
@Service
public class GoodsService {
	@Resource
	private GoodsDao goodsDao;

	/**
	 * 用户购买商品的业务 会出现 数据不一致的情况
	 *
	 * @param userId  用户ID
	 * @param goodsId 商品ID
	 * @param amount  购买数量
	 */
	public void buyGoods(int userId, int goodsId, int amount) {
		System.out.println("userId=" + userId + " goodsId=" + goodsId +
				" 数量=" + amount);

		//1.查询商品价格
		Float price = goodsDao.queryPriceById(goodsId);
		//2.减少用户余额
		goodsDao.updateBalance(userId, price * amount);
		//3.商品出库
		goodsDao.updateAmount(goodsId, amount);

		System.out.println("用户购买成功！");
	}

	/**
	 * @param userId
	 * @param goodsId
	 * @param amount
	 * @Transactional注解 1. 可以进行声明式事务控制
	 * 2.即将标识的方法中的 对数据库的操作 作为事务进行管理
	 * 3.底层是AOP机制
	 * 4.底层使用动态代理对象调用buyGoodsByTx
	 * 5.在执行buyGoodsByTx()之前，
	 * 先调用 事务管理器(DataSourceTransactionManager)的doBegin()方法，将自动提交设置为 false
	 * 如果没有发生异常，调用doCommit()方法
	 * 如果发生异常，调用doRollback()方法
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void buyGoodsByTx(int userId, int goodsId, int amount) {
		System.out.println("userId=" + userId + " goodsId=" + goodsId +
				" 数量=" + amount);

		//1.查询商品价格
		Float price = goodsDao.queryPriceById(goodsId);
		//2.减少用户余额
		goodsDao.updateBalance(userId, price * amount);
		//3.商品出库
		goodsDao.updateAmount(goodsId, amount);

		System.out.println("用户购买成功！");
	}

	//第二套方法 使用 GoodsDao的第二套方法
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	public void buyGoodsByTx2(int userId, int goodsId, int amount) {
		System.out.println("userId=" + userId + " goodsId=" + goodsId +
				" 数量=" + amount);

		//1.查询商品价格
		Float price = goodsDao.queryPriceById2(goodsId);
		//2.减少用户余额
		goodsDao.updateBalance2(userId, price * amount);
		//3.商品出库
		goodsDao.updateAmount2(goodsId, amount);

		System.out.println("用户购买成功！");
	}

	//在默认情况下，声明式事务的隔离级别是 REPEATABLE_READ 可重复读
	//在事务执行的过程中，如果价格被改动且提交，第二次查询到的结果 还是 提交前的 结果
	//如果Isolation.READ_COMMITTED 读已提交，只要是提交的数据，在当前事务可以被读取
	//即 在事务执行的过程中，如果价格被改动且提交，第二次查询到的结果 是 提交后的 结果
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void bugGoodsByTxIsolation() {
		//查询两次商品价格
		Float price1 = goodsDao.queryPriceById(1);
		System.out.println("第 1 次查询到的价格=" + price1);
		Float price2 = goodsDao.queryPriceById(1);
		System.out.println("第 2 次查询到的价格=" + price2);
	}

	//timeout = 2 表示如果 bugGoodsByTxTimeout()方法 执行的时间超过 2 s
	//该事物就会回滚
	//如果没有设置timeout属性，默认为 -1 使用数据库的默认超时时间，如果不支持则无(不回滚)
	@Transactional(timeout = 2)
	public void bugGoodsByTxTimeout(int userId, int goodsId, int amount) {
		System.out.println("userId=" + userId + " goodsId=" + goodsId +
				" 数量=" + amount);

		//1.查询商品价格
		Float price = goodsDao.queryPriceById(goodsId);
		//2.减少用户余额
		goodsDao.updateBalance(userId, price * amount);

		//模拟超时try {
		System.out.println("模拟超时4s");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("超时模拟结束");

		//3.商品出库
		goodsDao.updateAmount(goodsId, amount);

		System.out.println("用户购买成功！");
	}
}
