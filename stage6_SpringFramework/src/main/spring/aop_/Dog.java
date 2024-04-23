package main.spring.aop_;

import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 12:25
 * @description:
 **/
@Component
public class Dog implements Animal{
	@Override
	public float sum(float a, float b) {
		System.out.println("Dog sum() result=" + (a+b));
		return a + b;
	}

	@Override
	public float sub(float a, float b) {
		System.out.println("Dog sub() result=" + (a-b));
		return a - b;
	}
}
