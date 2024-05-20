package main.spring.practice.aop.proxy_dinamicalProxy;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 17:04
 * @description:
 **/
public class Car implements Vehicle{
	@Override
	public void run() {
		System.out.println("Car is running");
	}

	@Override
	public String fly(int height) {
		System.out.println("Car is flying at " + height + " km");
		return "Car is flying at " + height + " km";
	}
}
