package main.spring.practice.aop.aop;

import javafx.application.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 11:26
 * @description:
 **/
public class TestAOP {
	private ApplicationContext ioc;
	//错误的，必须从ioc容器中获取对象才能使用aop
	//monkey方法内部打印result=2.0
	//monkey方法内部打印result=Infinity
	@Test
	public void test() {
		Monkey monkey = new Monkey();
		double sum = monkey.getSum(1, 1);
		double division = monkey.getDivision(1, 0);
	}

	@BeforeEach
	public void init() {
		ioc = new ClassPathXmlApplicationContext("aop.xml");
	}

	//错误的，不能使用Monkey 接收，因为返回的类型是代理类型
	//org.springframework.beans.factory.BeanNotOfRequiredTypeException:
	// Bean named 'monkey' is expected to be of type 'main.spring.practice.aop.aop.Monkey'
	// but was actually of type 'com.sun.proxy.$Proxy21'
	@Test
	public void testAop() {
		Monkey monkey = ioc.getBean("monkey", Monkey.class);
		double sum = monkey.getSum(1, 1);
		double division = monkey.getDivision(1, 0);
	}

	@Test
	public void testAop2() {
		//TODO 必须使用接口类型接收
		SmartAnimal monkey = ioc.getBean("monkey", SmartAnimal.class);
		//class com.sun.proxy.$Proxy21
		System.out.println(monkey.getClass());
		System.out.println("==================sum===========");
		double sum = monkey.getSum(1, 2);
		System.out.println("==============division===========");
		double division = monkey.getDivision(1, 1);


	//	如果配置了多个切面，执行过程为：
	//	==================sum===========
		//环绕通知--前置：namegetSum  args:[1.0, 2.0]
		//前置通知 name:getSum  args:[1.0, 2.0]
		//monkey方法内部打印result=3.0
		//返回通知 name:getSum  args:[1.0, 2.0]res:3.0
		//最终通知 name:getSum  args:[1.0, 2.0]
		//环绕通知--返回：namegetSum  result:3.0
		//环绕通知--最终：namegetSum  args:[1.0, 2.0]
		//==============division===========
		//环绕通知--前置：namegetDivision  args:[1, 0]
		//异常通知 name:getDivision  args:[1, 0]  exception:java.lang.ArithmeticException: Division by zero
		//最终通知 name:getDivision  args:[1, 0]
		//环绕通知--异常：namegetDivision  exception:java.lang.ArithmeticException: Division by zero
		//环绕通知--最终：namegetDivision  args:[1, 0]
	}

	@Test
	public void test3_no_interfaces() {
		Car car = (Car) ioc.getBean("car01", Car.class);
		car.run();
	}

}
