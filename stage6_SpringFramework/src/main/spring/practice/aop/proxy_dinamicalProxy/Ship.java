package main.spring.practice.aop.proxy_dinamicalProxy;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 17:02
 * @description:
 **/
public class Ship implements Vehicle{
	@Override
	public void run() {
		System.out.println("ship is swimming");
	}

	@Override
	public String fly(int height) {
		System.out.println("ship is flying at " + height + " km");
		return "ship is flying at " + height + " km";
	}
}
