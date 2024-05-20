package main.spring.practice.aop.proxy_dinamicalProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 18:00
 * @description:
 **/
public class ProxyProvider {
	private final Vehicle target_vehicle;

	public ProxyProvider(Vehicle target_vehicle) {
		this.target_vehicle = target_vehicle;
	}

	public Vehicle getTarget_vehicle() {
		ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
		Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("start");
				Object invoke = method.invoke(target_vehicle, args);
				System.out.println("end");
				return invoke;
			}
		};

		Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
		return (Vehicle) o;
	}
}
