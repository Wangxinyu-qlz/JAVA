package qiaolezi.furniture.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-08 13:09
 * @description:
 **/
public class T1 {
	//测试能否得到Spring容器的数据源对象和会话工厂对象
	@Test
	public void testSqlSessionFactoryBean() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac.getBean("pooledDataSource"));
		System.out.println(ac.getBean("sqlSessionFactory"));

	}

}
