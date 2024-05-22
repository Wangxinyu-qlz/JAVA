package main.mySQL.practice.tx_practice.service;

import main.mySQL.practice.tx_practice.dao.GoodsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 15:24
 * @description:
 **/
@Service
public class GoodsService {
	@Resource
	private GoodsDao goodsDao;

	public void buyGoods(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	public void buyGoodsException(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);
		int i = 1 / 0;
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	@Transactional
	public void buyGoodsException_Transactional(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);
		int i = 1 / 0;
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void buyGoodsException_Transactional_propagation_REQUIRES_NEW_1(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById1(goods_id);
		goodsDao.updateGoodsNum1(goods_id, goods_num);
		//int i = 1 / 0;
		goodsDao.updateUserBalance1(user_id, price * goods_num);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void buyGoodsException_Transactional_propagation_REQUIRES_NEW_2(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);
		int i = 1 / 0;
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void buyGoodsException_Transactional_propagation_REQUIRED_1(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById1(goods_id);
		goodsDao.updateGoodsNum1(goods_id, goods_num);
		//int i = 1 / 0;
		goodsDao.updateUserBalance1(user_id, price * goods_num);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void buyGoodsException_Transactional_propagation_REQUIRED_2(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);
		int i = 1 / 0;
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	@Transactional(timeout = 2)
	public void buyGoodsTimeOut(int user_id, int goods_id, int goods_num) {
		Double price = goodsDao.queryPriceById(goods_id);
		goodsDao.updateGoodsNum(goods_id, goods_num);

		System.out.println("模拟超时4s");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("模拟超时结束");
		goodsDao.updateUserBalance(user_id, price * goods_num);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void buyGoodsByTxIsolation_READ_COMMITTED() {
		//查询两次商品价格
		Double price1 = goodsDao.queryPriceById(1);
		System.out.println("第 1 次查询到的价格=" + price1);
		Double price2 = goodsDao.queryPriceById(1);
		System.out.println("第 2 次查询到的价格=" + price2);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void buyGoodsByTxIsolation_REPEATABLE_READ() {
		//查询两次商品价格
		Double price1 = goodsDao.queryPriceById(1);
		System.out.println("第 1 次查询到的价格=" + price1);
		Double price2 = goodsDao.queryPriceById(1);
		System.out.println("第 2 次查询到的价格=" + price2);
	}
}
