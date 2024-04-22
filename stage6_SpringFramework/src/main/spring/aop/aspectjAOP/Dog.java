package main.spring.aop.aspectjAOP;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 20:28
 * @description:
 **/
@Component(value = "dog")
public class Dog implements SmartAnimal{
	@Override
	public double getSum(double a, double b) {
		System.out.println("dog方法内部打印result=" + (a + b));
		return a + b;
	}

	@Override
	public double getSub(double a, double b) {
		System.out.println("dog方法内部打印result=" + (a - b));
		return a - b;
	}

	@Override
	public double getDivision(int a, int b) {
		double result = (double) a / b;
		//int i = 1/0;
		System.out.println("dog方法内部打印result=" + result);
		return (double) a / b;
	}
}
