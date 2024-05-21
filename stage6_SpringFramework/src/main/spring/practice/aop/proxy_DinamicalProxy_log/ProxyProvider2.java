package main.spring.practice.aop.proxy_DinamicalProxy_log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 09:37
 * @description:
 **/
public class ProxyProvider2 {
	private final Calculator calculator;
	public ProxyProvider2(Calculator calculator) {
		this.calculator = calculator;
	}

	public Calculator getCalculator() {
		ClassLoader classLoader = calculator.getClass().getClassLoader();
		Class<?>[] interfaces = calculator.getClass().getInterfaces();
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				String name = method.getName();

				try {
					System.out.println("method-name:" + name + "args:" + Arrays.asList(args));
					result = method.invoke(calculator, args);
					System.out.println("method-name:" + name + "result:" + result);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					System.out.println("method-name:" + name + "exception:" + e.getMessage());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					System.out.println("method-name:" + name + "exception:" + e.getMessage());
				} catch (InvocationTargetException e) {// 1/0 是 InvocationTargetException
					e.printStackTrace();
					System.out.println("method-name:" + name + "exception:" + e.getMessage());
				} finally {
					System.out.println("method-name:" + name + " is executed.");
				}
				return result;
			}
		};

		return (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

	}
}
