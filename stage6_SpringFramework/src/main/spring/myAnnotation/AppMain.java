package main.spring.myAnnotation;

import main.spring.myAnnotation.ioc.MySpringApplicationContext;
import main.spring.myAnnotation.ioc.MySpringConfig;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 15:49
 * @description:
 **/
public class AppMain {
	public static void main(String[] args) {
		MySpringApplicationContext mySpringApplicationContext =
				new MySpringApplicationContext(MySpringConfig.class);

		System.out.println("OK!");
	}
}
