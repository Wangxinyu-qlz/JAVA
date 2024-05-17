package main.test;

import main.spring.practice.bean.Cat;
import main.spring.practice.bean.Monster;
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
		//TODO No qualifying bean of type 'main.spring.practice.bean.Monster' available:
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
		// 将工厂配置为prototype也无济于事
		System.out.println("==================静态工厂======================");
		ApplicationContext ioc = new ClassPathXmlApplicationContext("practice1.xml");
		Monster staticMonsterFactory = (Monster)ioc.getBean("staticMonsterFactory");
		System.out.println(staticMonsterFactory + "  hashCode:" + staticMonsterFactory.hashCode());
		Monster staticMonsterFactory2 = (Monster)ioc.getBean("staticMonsterFactory");
		System.out.println(staticMonsterFactory2 + "  hashCode:" + staticMonsterFactory2.hashCode());

		//实例工厂
		System.out.println("==================实例工厂======================");
		Monster monster = ioc.getBean("monsterFactory", Monster.class);
		System.out.println(monster + "hashCode:" + monster.hashCode());
		Monster monster1 = ioc.getBean("monsterFactory1", Monster.class);
		System.out.println(monster1 + "hashCode:" + monster1.hashCode());

		System.out.println("==================FactoryBean======================");
		Monster monster2 = ioc.getBean("monsterFactoryUseFactoryBean", Monster.class);
		System.out.println(monster2 +"hashCode:" + monster2.hashCode());

		System.out.println("==================FactoryBean======================");
		Monster monster3 = ioc.getBean("myFactoryBean", Monster.class);
		System.out.println(monster3 + "hashCode:" + monster3.hashCode());
	}

	@Test
	void TestParent() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("practice1.xml");
		Monster monster2 = ioc.getBean("monster2", Monster.class);
		System.out.println(monster2);
		((ConfigurableApplicationContext) ioc).close();
	}

	//
	@Test
	void TestDependenceOn() {
		/*正常执行：
		Cat::Constructor NULL
		Cat init
		Monster::Constructor NULL
		这是杰瑞init捣乱了吧
		杰瑞走了
		Cat destroy
		* */

		/*depend-on = monster
		Monster::Constructor NULL
		这是杰瑞init捣乱了吧
		Cat::Constructor NULL
		Cat init
		Cat destroy
		杰瑞走了
		* */
		ApplicationContext ioc = new ClassPathXmlApplicationContext("dependenceTest.xml");
		Cat cat2 = ioc.getBean("cat", Cat.class);
		Monster monster2 = ioc.getBean("monster", Monster.class);

		((ConfigurableApplicationContext) ioc).close();
	}

	@Test
	void TestDependenceOn2() {
		/*
		* Monster::Constructor NULL
		这是杰瑞init捣乱了吧
		Cat::Constructor NULL
		Cat init
		Cat destroy
		杰瑞走了
		* */
		ApplicationContext ioc = new ClassPathXmlApplicationContext("dependenceTest.xml");
		Monster monster2 = ioc.getBean("monster2", Monster.class);

		((ConfigurableApplicationContext) ioc).close();
	}

	@Test
	void TestDestroyWithPrototype() {
		/*TODO 当一个bean配置为多例时，ioc容器关闭时，不会调用该bean的destroy()方法，因为多例bean不在ioc容器的管理范围内
		   多例bean每次调用都会创建
		Monster::Constructor NULL
		这是杰瑞init捣乱了吧*/
		ApplicationContext ioc = new ClassPathXmlApplicationContext("testDestroyWithPrototype.xml");
		Monster monster2 = ioc.getBean("monster", Monster.class);

		((ConfigurableApplicationContext) ioc).close();
	}
}
