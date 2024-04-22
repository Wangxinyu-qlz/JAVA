package main.spring.aop.proxyPractice;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:19
 * @description:
 **/
public class Ship implements Vehicle {
	@Override
	public void run() {
		System.out.println("船");
	}

	@Override
	public String fly(int height) {
		System.out.println("船" + height);
		return "船" + height;
	}
}
