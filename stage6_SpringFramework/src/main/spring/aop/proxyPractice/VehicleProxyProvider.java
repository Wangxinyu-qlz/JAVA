package main.spring.aop.proxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:20
 * @description:
 **/
public class VehicleProxyProvider {
	private final Vehicle target_vehicle;

	public VehicleProxyProvider(Vehicle targetVehicle) {
		this.target_vehicle = targetVehicle;
	}

	public Vehicle getProxy() {
		ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
		Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				System.out.println("Vehicle start");
				Object result = method.invoke(target_vehicle, args);
				System.out.println("Vehicle stop");

				return result;
			}
		};
		return (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
