package main.spring.component_;

import main.spring.aop_.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 11:54
 * @description:
 **/
public class AppMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans11.xml");
		/**
		 * TODO 没有init()方法也会调用后置处理器
		 * before  class main.spring.component_.UserDao
		 * after  class main.spring.component_.UserDao
		 * before  class main.spring.component_.UserService
		 * UserService init()
		 * after  class main.spring.component_.UserService
		 * TODO 切面类的后置处理器也会生效
		 * before  class main.spring.aop_.AnimalAspect
		 * after  class main.spring.aop_.AnimalAspect
		 * before  class main.spring.aop_.Dog  初始化之前是原始类型
		 * after  class com.sun.proxy.$Proxy20  初始化之后是代理类型
		 * 单例只调用一次 多例有多少个对象，就调用多少次
		 * before  class main.spring.component_.UserAction
		 * after  class main.spring.component_.UserAction
		 * before  class main.spring.component_.UserAction
		 * after  class main.spring.component_.UserAction
		 */
		UserAction userAction = (UserAction)ioc.getBean("userAction");
		UserAction userAction2 = (UserAction)ioc.getBean("userAction");
		System.out.println(userAction==userAction2);//true(singleton) false(prototype)

		UserDao userDao = (UserDao)ioc.getBean("userDao");
		System.out.println("userDao=" + userDao);

		UserService userService = (UserService)ioc.getBean("userService");
		System.out.println("userService=" + userService);

		System.out.println("=======================");
		Animal dog = (Animal)ioc.getBean("dog");
		dog.sum(1, 1);

	}
}
