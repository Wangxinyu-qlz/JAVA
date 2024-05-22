package main.mySQL.practice.tx_practice.test;

import main.mySQL.practice.tx_practice.dao.GoodsDao;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 14:56
 * @description:
 **/
public class TestGoodsDao {
	private ApplicationContext ioc;
	@BeforeEach
	public void init() {
		ioc = new ClassPathXmlApplicationContext("tx_p.xml");
	}

	@Test
	public void testQueryPriceById() {
		int id = 1;
		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		Double price = goodsDao.queryPriceById(id);
		System.out.println(price);
	}

	@Test
	public void testUpdateGoodsNumByGoodsId() {
		int id = 1;
		int goodsNum = 20;
		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		goodsDao.updateGoodsNum(id, goodsNum);
		System.out.println("success!");
	}

	@Test
	public void testUpdateUserBalance() {
		int id = 10;
		double money = 1;
		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		goodsDao.updateUserBalance(id, money);
		System.out.println("success!");
	}


}
