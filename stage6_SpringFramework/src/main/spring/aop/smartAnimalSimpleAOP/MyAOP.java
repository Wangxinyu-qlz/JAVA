package main.spring.aop.smartAnimalSimpleAOP;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 19:03
 * @description: 实现简易AOP类
 **/
public class MyAOP {
	//在目标对象执行前 执行的方法
	public static void before(Method method, Object[] args) {
		System.out.println("MyAOP before 日志-方法名-" + method.getName() + "-参数-" + Arrays.asList(args));
	}

	//在目标对象执行后 执行的方法
	public static void after(Method method, Object result) {
		System.out.println("MyAOP after 日志-方法名-" + method.getName() + "-结果-" + result);
	}
}
