package main.test;


import main.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-04 22:36
 * @description:
 **/
public class springBeanTest {
	@Test
	public void getMonster() {
		//1.创建容器ApplicationContext
		//2.该容器和容器配置文件关联
		//TODO ClassPath 类加载路径，不是src/beans.xml
		//ApplicationContext
		ApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		//3.可以通过getBean()获取对应的对象，传入ID
		//  默认返回oObject，运行类型是Monster
		Object monster01 = ioc.getBean("monster01");
		//monster01=Monster{id=1, name='牛魔', skill='撼天动地'}
		System.out.println("monster01=" + monster01);
		//monster01运行类型=class main.spring.bean.Monster
		System.out.println("monster01运行类型=" + monster01.getClass());

		//这里需要转换类型才能直接.getId()
		System.out.println(((Monster)monster01).getId());

		//4.可以在获取的时候，直接指定Class类型
		Monster monster011 = ioc.getBean("monster01", Monster.class);
		Integer id = monster011.getId();
		System.out.println(id);
	}

	@Test
	public void getClassPath() {
		/**
		 * getResource():
		 * 查找具有给定名称的资源。搜索与给定类关联的资源的规则由该类的定义类装入器实现。
		 * 此方法委托给此对象的类装入器。如果此对象是由引导类加载器加载的，
		 * 则该方法将委托给 ClassLoader.getSystemResource。
		 * 在委派之前，使用以下算法从给定的资源名称构造绝对资源名称：
		 * 如果名称以'/' ('\u002f')开头，则资源的绝对名称是名称中'/'后面的部分。
		 * 否则，绝对名称的格式如下： modified_package_namename
		 * 其中modified_package_name是此对象的包名称，其中'/'替换为 '.' ('\u002e')。
		 */
		File file = new File(this.getClass().getResource("/").getPath());
		//class main.test.springBeanTest
		System.out.println("this.getClass()=" + this.getClass());
		//TODO 类的加载路径
		//file=C:\My_Code\Java\stage6_SpringFramework\target\classes
		System.out.println("file=" + file);
	}
}
