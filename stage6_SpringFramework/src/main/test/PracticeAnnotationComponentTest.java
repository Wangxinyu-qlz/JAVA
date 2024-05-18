package main.test;

import main.spring.practice.annotation_component.Dao;
import main.spring.practice.annotation_component.MyComponent;
import main.spring.practice.annotation_component.UserAction;
import main.spring.practice.annotation_component.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 12:06
 * @description:
 **/
public class PracticeAnnotationComponentTest {
	private static ApplicationContext ioc;

	@BeforeEach
	void init() {
		ioc = new ClassPathXmlApplicationContext("annotationComponent.xml");
	}

	@Test
	void testAnnotationComponent() {
		UserAction userAction = ioc.getBean("userAction", UserAction.class);
		System.out.println(userAction);
		userAction.say();
	}

	@Test
	void testExclude() {
		MyComponent myComponent = ioc.getBean("myComponent", MyComponent.class);
		System.out.println(myComponent);
	}

	@Test
	void testInclude_use_default_filter_false() {
		MyComponent myComponent = ioc.getBean("myComponent", MyComponent.class);
		System.out.println(myComponent);  // ok

		Dao dao = ioc.getBean("dao", Dao.class);
		System.out.println(dao);  // ok

		UserAction userAction = ioc.getBean("userAction", UserAction.class);
		System.out.println(userAction);  //ok

		UserService userService = ioc.getBean("userService", UserService.class);
		System.out.println(userService);
	}
}
