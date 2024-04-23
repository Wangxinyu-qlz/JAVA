package main.spring.aop.aspectAopPractice;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.management.HotspotClassLoadingMBean;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 10:21
 * @description:
 **/
public class TestCalculator {
	@Test
	public void testCalculator() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans10.xml");

		Calculator phone = (Calculator)ioc.getBean("phone");
		Calculator computer = (Calculator)ioc.getBean("computer");

		phone.sum(1, 1);
		System.out.println();
		phone.sub(12, 4);
		System.out.println();
		phone.multi(2, 90);
		System.out.println();
		phone.division(3, 0);

	}
}
