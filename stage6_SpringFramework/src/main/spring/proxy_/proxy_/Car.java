package main.spring.proxy_.proxy_;


/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 15:11
 * @description:
 **/
public class Car implements Vehicle {
	@Override
	public void run() {
		//System.out.println("交通工具开始运行了...");
		System.out.println("小汽车 在路上running...");
		//System.out.println("交通工具停止运行...");
	}

	@Override
	public String fly(int height) {
		System.out.println("汽车在天上飞 高度=" + height);
		return "汽车在天上飞 高度=" + height;
	}
}
