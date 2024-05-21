package main.spring.practice.aop.aop;

import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:33
 * @description:
 **/
@Component(value = "monkey")
public class Monkey implements SmartAnimal {
	@Override
	public double getSum(double a, double b) {
		System.out.println("monkey方法内部打印result=" + (a + b));
		return a + b;
	}

	@Override
	public double getSub(double a, double b) {
		System.out.println("monkey方法内部打印result=" + (a - b));
		return a - b;
	}

	//@Override
	//public double getDivision(int a, int b) {
	//	if (b == 0) {
	//		throw new ArithmeticException("除数不能为0");
	//	}
	//	double result = (double) a / b;
	//	System.out.println("monkey方法内部打印result=" + result);
	//	return result;
	//}


	@Override
	public double getDivision(int a, int b) {
		return SmartAnimal.super.getDivision(a, b);
	}
}
