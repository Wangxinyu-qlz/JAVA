package main.spring.aop.smartAnimalSimpleAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:36
 * @description:
 **/
public class SmartAnimalProxyProvider {
	SmartAnimal smartAnimal = new Monkey();
	public SmartAnimalProxyProvider(SmartAnimal smartAnimal) {
		this.smartAnimal = smartAnimal;
	}

	////在目标对象执行前 执行的方法
	//public void before(Method method, Object[] args) {
	//	System.out.println("before 日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
	//}
	//
	////在目标对象执行后 执行的方法
	//public void after(Method method, Object result) {
	//	System.out.println("after 日志-方法名-" + method.getName() + "-结果-" + result);
	//}

	public SmartAnimal getProxy() {
		ClassLoader classLoader = smartAnimal.getClass().getClassLoader();
		Class<?>[] interfaces = smartAnimal.getClass().getInterfaces();
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) {
				Object result = null;
				try {
					//before(method, args);
					MyAOP.before(method, args);//从AOP看，这里是一个横切关注点，前置通知
					result = method.invoke(smartAnimal, args);
					//after(method, result);
					MyAOP.after(method, result);//从AOP看，这里是一个横切关注点，返回通知
				} catch (Exception e) {
					e.printStackTrace();
					//如果反射执行方法出现异常，进入到catch{}
					//TODO 从AOP看，这里是一个横切关注点，异常通知
					System.out.println("日志-方法名-" + method.getName() + "-异常类型：" + e.getClass().getName());
				} finally {//无论是否出现异常，最终都会执行到此处
					System.out.println("方法最终结束-日志-方法名-" + method.getName());
				}

				return result;
			}
		};

		return (SmartAnimal) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
