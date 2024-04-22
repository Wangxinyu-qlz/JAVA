package main.spring.aop.proxyPractice;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:17
 * @description:
 **/
public class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("Car");
	}

	@Override
	public String fly(int height) {
		System.out.println("汽车" + height);
		return "汽车" + height;
	}
}
