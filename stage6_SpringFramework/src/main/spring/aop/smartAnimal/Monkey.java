package main.spring.aop.smartAnimal;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:33
 * @description:
 **/
public class Monkey implements SmartAnimal{
	@Override
	public double getSum(double a, double b) {
		System.out.println("方法内部打印result=" + (a + b));
		return a + b;
	}

	@Override
	public double getSub(double a, double b) {
		System.out.println("方法内部打印result=" + (a - b));
		return a - b;
	}
}
