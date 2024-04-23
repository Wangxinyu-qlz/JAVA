package main.spring.aop.aspectAopPractice;

import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 10:03
 * @description:
 **/
@Component
public class Phone implements Calculator {
	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public float division(int a, int b) {
		//assert b!=0 : "divide by 0!";
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero is not allowed!");
		}
		return (float) a / b;
	}

	@Override
	public int multi(int a, int b) {
		return a * b;
	}
}
