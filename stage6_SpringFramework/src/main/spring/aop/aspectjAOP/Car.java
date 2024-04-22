package main.spring.aop.aspectjAOP;

import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 20:41
 * @description:
 **/
@Component
public class Car {
	public void run() {
		System.out.println("car run()...");
	}
}
