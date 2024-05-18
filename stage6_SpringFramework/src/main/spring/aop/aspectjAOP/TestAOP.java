package main.spring.aop.aspectjAOP;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 19:39
 * @description:
 * TODO 动态代理jdk的Proxy与spring的CGlib
 *  两个动态代理的区别
 *      JDK动态代理是面向接口的，只能增强实现类中接口中存在的方法。CGlib是面向父类的，可以增强父类的所有方法
 *      JDK得到的对象是JDK代理对象实例，而CGlib得到的对象是被代理对象的子类
 **/
public class TestAOP {
	@Test
	public void testAOP() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");

		//通过接口类型获取到注入的Monkey对象-即代理对象  TODO 此方式要求容器中只有一个对象
		//main.spring.aop.aspectjAOP.Monkey@508dec2b
		//SmartAnimal bean = ioc.getBean(SmartAnimal.class);
		//System.out.println(bean);
		//bean.getSum(12, 4);
		//bean.getSub(12, 4);
		//bean.getDivision(1, 1);

		//TODO 如果在beans08.xml中开启了aop-proxy <aop:aspectj-autoproxy/>，如果不开启，AOP失效
		// 开启AOP后，只能获取代理对象  下面的代码出错
		//Monkey bean1 = ioc.getBean(Monkey.class);
		//Monkey smartAnimal = (Monkey) ioc.getBean("monkey");//错
		// 但是可以通过ID获取，转型为代理对象
		SmartAnimal monkey = (SmartAnimal) ioc.getBean("monkey");//OK
		//monkey的运行类型class com.sun.proxy.$Proxy19
		System.out.println("monkey的运行类型" + monkey.getClass());
		//monkey.getSub(1, 1);
		monkey.getSum(1, 1);
		//monkey.getDivision(1, 1);

		//SmartAnimal dog = (SmartAnimal) ioc.getBean("dog");//OK
		//dog.getSub(2, 1);
	}

	//TODO 切入表达式可以对 没有实现接口的类 进行切入
	//https://www.cnblogs.com/threeAgePie/p/15832586.html
	@Test
	public void test1() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");

		Car car = (Car)ioc.getBean("car");
		//TODO 这里的car其实是car的一个子类
		//class main.spring.aop.aspectjAOP.Car$$EnhancerBySpringCGLIB$$7b774219
		System.out.println(car.getClass());
		car.run();
	}

	@Test
	public void testAround(){
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");

		SmartAnimal monkey = (SmartAnimal)ioc.getBean("monkey");
		monkey.getSum(1, 1);
		monkey.getSub(1, 2);
		monkey.getDivision(1, 3);
		System.out.println("OK~");
	}
}
