package main.mySQL.practice.tx.test;

import main.mySQL.practice.tx.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 11:58
 * @description:
 **/
public class TestGoodsService {
	@Test
	public void test() {
		ApplicationContext ioc =
				new ClassPathXmlApplicationContext("tx_practice.xml");
		GoodsService bean = ioc.getBean(GoodsService.class);
		bean.bugGoods(1, 2, 1);
		System.out.println("购买成功！");
	}

	@Test
	public void test_Exception() {
		ApplicationContext ioc =
				new ClassPathXmlApplicationContext("tx_practice.xml");
		GoodsService bean = ioc.getBean(GoodsService.class);
		bean.bugGoods_Exception(1, 2, 1);
		System.out.println("购买成功！");
	}
}
