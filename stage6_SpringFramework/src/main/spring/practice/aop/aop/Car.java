package main.spring.practice.aop.aop;

import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 20:41
 * @description:
 **/
@Component(value = "car01")
public class Car {
	public void run() {
		System.out.println("111car run()...");
	}
}
