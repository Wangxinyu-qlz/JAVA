package main.test;


import main.spring.practice.bean.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 11:09
 * @description:
 **/
public class PracticeTest2BeanPostFactory {
	private ApplicationContext ioc;
	@BeforeEach
	void init() {
		ioc = new ClassPathXmlApplicationContext("beanPostProcessor.xml");
	}

	@Test
	void testBeanPostProcessor() {
		Cat cat = ioc.getBean("cat", Cat.class);
		System.out.println(cat);
	}

}
