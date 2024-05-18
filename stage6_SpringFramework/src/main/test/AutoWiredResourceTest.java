package main.test;

import main.spring.practice.autoWiredResource.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 16:16
 * @description:
 **/
public class AutoWiredResourceTest {
	private ApplicationContext ioc;
	@BeforeEach
	void init() {
		ioc = new ClassPathXmlApplicationContext("autoWiredResource.xml");
	}

	@Test
	void testAutoWiredResource() {
		Animal animal = ioc.getBean("animal", Animal.class);
		System.out.println(animal);

		//class main.spring.practice.autoWiredResource.Animal
		System.out.println(Animal.class);
	}
}
