package main.spring.practice.aop.proxy_DinamicalProxy_log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 22:27
 * @description:
 **/
public class ProxyProvider_ {
	private final Calculator calculator;
	public ProxyProvider_(Calculator calculator) {
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
				try{
					System.out.println("日志--方法名：" + name + " 参数：" + Arrays.asList(args));
					result = method.invoke(calculator, args);
					System.out.println("日志--方法名：" + name + " 结果：" + result);
				} catch (Exception e){
					e.printStackTrace();
					System.out.println("日志-方法名：" + name + " 异常：" + e.getMessage());
				} finally {
					System.out.println("日志--方法名" + name + " 最终结束");
				}
				return result;
			}
		};

		return (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
