package main.spring.aop.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 19:39
 * @description:
 * 动态代理jdk的Proxy与spring的CGlib
 * 两个动态代理的区别
 *      JDK动态代理是面向接口的，只能增强实现类中接口中存在的方法。CGlib是面向父类的，可以增强父类的所有方法
 *      JDK得到的对象是JDK代理对象实例，而CGlib得到的对象是被代理对象的子类
 **/
public class TestAopXml {
	@Test
	public void testAopXml() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans09.xml");

		SmartAnimal monkey = (SmartAnimal)ioc.getBean("monkey");
		monkey.getSum(1, 1);
		System.out.println("OK~");
	}
}
