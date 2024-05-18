package main.spring.aop.proxy2_dynamicalProxy;

import org.junit.jupiter.api.Test;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 15:51
 * @description:
 **/
public class TestVehicle {
	@Test
	public void testVehicle() {
		//编译类型：Vehicle
		//运行类型：Ship
		Vehicle vehicle = new Ship();
		VehicleProxyProvider vehicleProxyProvider =
				new VehicleProxyProvider(vehicle);

		//获取代理对象
		//编译类型：Vehicle
		//TODO 运行类型：代理类型 class com.sun.proxy.$Proxy8
		Vehicle proxy = vehicleProxyProvider.getProxy();
		//proxy的运行类型是：class com.sun.proxy.$Proxy8
		System.out.println("proxy的运行类型是：" + proxy.getClass());

		//执行到代理对象的 public Object invoke(Object obj, Object... args)
		//proxy的编译类型是Vehicle，运行类型是class com.sun.proxy.$Proxy8
		//执行run()方法时，执行到代理对象的invoke()方法
		//如何体现动态的概念：1.被代理的对象 2.被代理对象的方法
		proxy.run();
		System.out.println("=================");

		String result = proxy.fly(1000);
		System.out.println(result);
	}
}
