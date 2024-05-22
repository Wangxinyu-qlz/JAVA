package main.mySQL.practice.tx_practice.test;

import main.mySQL.practice.tx_practice.service.GoodsService;
import main.mySQL.practice.tx_practice.service.MultiplyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 15:27
 * @description:
 **/
public class testTX {
	private ApplicationContext ioc;

	@BeforeEach
	public void init() {
		ioc = new ClassPathXmlApplicationContext("tx_p.xml");
	}

	@Test
	public void testBuyGoods() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoods(1, 1, 1);
		System.out.println("success");
	}

	@Test
	public void testBuyGoodsException() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		//Error 异常之前的执行了，之后的没执行，用户余额和商品库存一致性被破坏
		goodsService.buyGoodsException(1, 1, 1);
		System.out.println("success");
	}

	@Test
	public void testBuyGoodsException_Transactional() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		//Error 发生异常，buyGoodsException_Transactional整体回滚，保证了用户余额和商品库存一致性
		goodsService.buyGoodsException_Transactional(1, 1, 1);
		System.out.println("success");
	}

	//1先执行，发生异常，回滚，2不执行
	@Test
	public void testBuyGoodsException_Transactional_defaultPropagation() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoodsException_Transactional_propagation_REQUIRES_NEW_1(1, 1, 1);
		goodsService.buyGoodsException_Transactional_propagation_REQUIRES_NEW_2(2, 2, 1);
		System.out.println("success");
	}

	//REQUIRES_NEW:一个事务发生异常另一个不会回滚，彼此独立
	//@Transactional[@Transactional(propagation = propagation.REQUIRES_NEW)
	//               @Transactional(propagation = propagation.REQUIRES_NEW)]
	@Test
	public void testBuyGoodsException_Transactional_propagation_REQUIRES_NEW() {
		MultiplyService bean = ioc.getBean(MultiplyService.class);
		bean.multiService_propagation_REQUIRES_NEW(1, 1, 1);
		System.out.println("success");
	}

	//REQUIRED:一个事务失败，全部回滚
	// @Transactional[@Transactional(propagation = propagation.REQUIRED)
	//                @Transactional(propagation = propagation.REQUIRED)]
	@Test
	public void testBuyGoodsException_Transactional_propagation_REQUIRED() {
		MultiplyService bean = ioc.getBean(MultiplyService.class);
		bean.multiService_propagation_REQUIRED(1, 1, 1);
		System.out.println("success");
	}

	//超时回滚事务
	@Test
	public void testBuyGoodsTimeOut() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoodsTimeOut(1, 1, 1);
		System.out.println("success!");
	}

	//测试事务的隔离级别
	//READ_COMMITTED:事务执行中，如果字段的值被更该且提交，则可以被当前事务读取
	@Test
	public void testBuyGoodsByTxIsolation_READ_COMMITTED() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoodsByTxIsolation_READ_COMMITTED();
		System.out.println("over");
	}

	//测试事务的隔离级别
	//REPEATABLE_READ:事务执行中，如果字段的值被更该且提交，不可以被当前事务读取，当前事务读取的值是该事务执行前的值
	@Test
	public void testBuyGoodsByTxIsolation_REPEATABLE_READ() {
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoodsByTxIsolation_REPEATABLE_READ();
		System.out.println("over");
	}
}
