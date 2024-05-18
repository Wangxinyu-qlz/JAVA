package main.spring.aop.proxy1_dynamicalProxyClassicalMethod;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 15:12
 * @description:
 **/
public class Ship implements Vehicle {
	@Override
	public void run() {
		System.out.println("交通工具开始运行了...");
		System.out.println("轮船 在海上running...");
		System.out.println("交通工具停止运行...");
	}
}
