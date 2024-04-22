package main.spring.aop.xml;


/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:33
 * @description:
 **/
//@Component(value = "monkey")
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

	@Override
	public double getDivision(int a, int b) {
		double result = (double) a / b;
		//int i = 1/0;
		System.out.println("monkey方法内部打印result=" + result);
		return (double) a / b;
	}
}
