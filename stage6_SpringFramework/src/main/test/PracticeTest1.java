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
		Monster monster2 = ioc.getBean("monster1", Monster.class);
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

		/*
		depend-on = monster
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
		/* TODO 如果只调用被依赖的bean，依赖该bean的bean的构造器、init()和destroy()也会被调用
		* Monster::Constructor NULL
		这是杰瑞init捣乱了吧
		Cat::Constructor NULL
		Cat init
		Cat destroy
		杰瑞走了
		* */
		ApplicationContext ioc = new ClassPathXmlApplicationContext("dependenceTest.xml");
		Monster monster = ioc.getBean("monster", Monster.class);

		((ConfigurableApplicationContext) ioc).close();
	}

	@Test
	void TestDestroyWithPrototype() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("testDestroyWithPrototype.xml");
		/*TODO 当一个bean配置为多例时，ioc容器关闭时，不会调用该bean的destroy()方法
		       多例bean每次调用都会创建，destroy()方法可以选择手动调用
		Monster::Constructor NULL
		这是杰瑞init捣乱了吧*/
		Monster monster_prototype = ioc.getBean("monster_prototype", Monster.class);
		/*
		Monster::Constructor NULL
		这是杰瑞init捣乱了吧
		杰瑞走了
		 */
		Monster monster_singleton = ioc.getBean("monster_singleton", Monster.class);
		//多例Bean，手动调用destroy()才会执行
		//杰瑞走了
		monster_prototype.destroy();//手动调用销毁方法

		Monster monster_prototype1 = ioc.getBean("monster_prototype", Monster.class);
		System.out.println(monster_prototype.hashCode() + "  vs  " + monster_prototype1.hashCode());
		((ConfigurableApplicationContext) ioc).close();//这里会调用单例 Bean 的destroy()
	}
}
