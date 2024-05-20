package main.spring.practice.aop.proxy_dinamicalProxy;

import org.junit.jupiter.api.Test;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 17:11
 * @description:
 **/
public class TestProxyVehicle {
	@Test
	public void testProxyVehicle() {
		Car car = new Car();
		VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(car);
		Vehicle targetVehicle = vehicleProxyProvider.getTarget_vehicle();

		targetVehicle.run();
		String fly = targetVehicle.fly(1);
		System.out.println("返回的结果是" + fly);
	}

	@Test
	public void testProxyVehicle2() {
		Ship ship = new Ship();
		ProxyProvider ProxyProvider = new ProxyProvider(ship);
		Vehicle targetVehicle = ProxyProvider.getTarget_vehicle();
		targetVehicle.run();
		String fly = targetVehicle.fly(1);
		System.out.println("返回结果" + fly);
	}
}
