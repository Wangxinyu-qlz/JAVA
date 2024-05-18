package main.spring.annotation;

import main.spring.componentAutoWiredResource.UserAction;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 17:34
 * @description:
 **/
public class MyspringApplicationContextTest {
	public static void main(String[] args) {
		MySpringApplicationContext ioc = new MySpringApplicationContext(MySpringConfig.class);

		UserAction userAction = (UserAction)ioc.getBean("UserAction");
		System.out.println(userAction);
		System.out.println("ok");
	}
}
