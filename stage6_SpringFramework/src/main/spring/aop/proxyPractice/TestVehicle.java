package main.spring.aop.proxyPractice;

import org.junit.jupiter.api.Test;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:27
 * @description:
 **/
public class TestVehicle {
	@Test
	public void testVehicle(){
		Vehicle vehicle = new Car();
		VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);

		Vehicle proxy = vehicleProxyProvider.getProxy();
		proxy.run();
		String fly = proxy.fly(100);
		System.out.println(fly);
		System.out.println("OK~");
	}
}
