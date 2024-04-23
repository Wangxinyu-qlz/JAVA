package main.spring.aop.aspectjAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 21:18
 * @description: 环绕通知
 **/
//@Aspect1
//@Component
public class SmartAnimalAspect2 {
	//1.@Around：这是一个环绕通知，完成前置 返回 异常 最终（后置）的功能
	//2."execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))" 切入点表达式
	//3.doAround 表示要切入的方法
	@Around(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.*(double, double))")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		try {
			//1.相当于前置通知
			Object[] args = joinPoint.getArgs();
			List<Object> argsList = Arrays.asList(args);
			System.out.println("AOP环绕通知--" + methodName + "方法开始了--参数有：" + argsList);

			//执行   在环绕通知中，一定要使用 joinPoint.proceed()执行目标方法
			result = joinPoint.proceed();

			//2.相当于返回通知
			System.out.println("AOP环绕通知" + methodName + "方法结束了--结果是：" + result);
		} catch (Throwable throwable) {
			//3.相当于异常通知
			System.out.println("AOP环绕通知--" + methodName + "方法抛出异常--异常对象：" + throwable);
		} finally {
			//4.相当于最终（后置通知）
			System.out.println("AOP环绕通知--" + methodName + "方法最终结束了");
		}

		return result;
	}


}
