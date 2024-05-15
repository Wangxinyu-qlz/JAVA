package main.test;

import main.spring.practice.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 20:55
 * @description:
 **/
public class PracticeTest1 {
	@Test
	void test1() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("practice1.xml");
		//TODO No qualifying bean of type 'main.spring.practice.Monster' available:
		// expected single matching bean but found 2: monster1,staticMonsterFactory
		Monster monster = (Monster) ioc.getBean("monster1", Monster.class);
		Monster monster1 = (Monster)ioc.getBean("monster1");
		System.out.println("monster: " + monster);
		System.out.println("monster1: " + monster1);

		((ConfigurableApplicationContext)ioc).close();
	}
	@Test
	void testFactory() {
		//TODO 静态工厂本身无法多例?? 是的，静态方法创建的对象ioc无法管理
		ApplicationContext ioc = new ClassPathXmlApplicationContext("practice1.xml");
		Monster staticMonsterFactory = (Monster)ioc.getBean("staticMonsterFactory");
		System.out.println(staticMonsterFactory.hashCode());
		Monster staticMonsterFactory2 = (Monster)ioc.getBean("staticMonsterFactory");
		System.out.println(staticMonsterFactory2.hashCode());
	}
}
