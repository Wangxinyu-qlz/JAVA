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
public class PracticeTest2BeanPostProcessor {
	private ApplicationContext ioc;
	@BeforeEach
	void init() {
		ioc = new ClassPathXmlApplicationContext("beanPostProcessor.xml");
	}

	@Test
	void testBeanPostProcessor() {
		//Cat::Constructor NULL
		//before bean post process
		//Cat init
		//after bean post process
		//Cat{name='宝宝', age=12}
		Cat cat = ioc.getBean("cat", Cat.class);
		System.out.println(cat);
	}

}
