package qiaolezi.furniture.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qiaolezi.furniture.bean.Furn;

import java.math.BigDecimal;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-10 17:19
 * @description:
 **/
public class FurnServiceTest {
	//属性
	private ApplicationContext ioc;
	//TODO 从spring容器中获取的是furnService接口对象/代理对象
	//这里不使用FurnServiceImplement
	private FurnService furnService;

	@Before
	public void init() {
		ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过FurnService.class 类型获取FurnService接口对象/代理对象
		furnService = ioc.getBean(FurnService.class);
		//qiaolezi.furniture.service.impl.FurnServiceImplement@5be49b60
		System.out.println(furnService);
	}

	@Test
	public void test() {
		Furn furn = new Furn(null, "北欧风格沙发~", "顺平家居~", new BigDecimal(180), 666,
				7, "assets/images/product-image/1.jpg");
		furnService.save(furn);
		//Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@3b96c42e]
		//Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults
		//sqlSession.close()自动完成
		System.out.println("save ok");
	}
}
