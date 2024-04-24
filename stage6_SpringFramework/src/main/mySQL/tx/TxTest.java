package main.mySQL.tx;

import main.mySQL.tx.dao.GoodsDao;
import main.mySQL.tx.service.GoodsService;
import main.mySQL.tx.service.MultiplyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-24 10:00
 * @description:
 **/
public class TxTest {
	@Test
	public void testGoodsDaoQueryPriceById() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");

		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		Float price = goodsDao.queryPriceById(1);
		System.out.println(price);
	}

	@Test
	public void testGoodsDaoUpdateBalance() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");

		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		goodsDao.updateBalance(1, 1.0f);
		System.out.println("扣款成功！");
	}

	@Test
	public void testGoodsDaoUpdateAmount() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");

		GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
		goodsDao.updateAmount(1, 1);
		System.out.println("出库成功！");
	}

	@Test
	public void testGoodsService() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoods(1, 1, 1);
	}

	@Test
	public void testGoodsServiceByTx() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
		GoodsService goodsService = ioc.getBean(GoodsService.class);
		goodsService.buyGoodsByTx(1, 1, 1);
	}

	@Test
	public void testMultiGoodsServiceByTx() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
		MultiplyService multiplyService = ioc.getBean(MultiplyService.class);
		multiplyService.multiBuyGoods(1, 1, 1);
	}

	//测试声明式事务的隔离级别
	@Test
	public void testBugGoodsByTxIsolation() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
		GoodsService bean = ioc.getBean(GoodsService.class);
		bean.bugGoodsByTxIsolation();
	}
}
