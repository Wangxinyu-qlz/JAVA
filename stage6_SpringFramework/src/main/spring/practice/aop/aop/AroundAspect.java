package main.spring.practice.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 12:06
 * @description:
 **/
//@Aspect()
//@Component
//@Order(2)//设置切面执行优先级
public class AroundAspect {
	@Around(value = "execution(* *.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		try {
			System.out.println("环绕通知--前置：name" + name + "  args:" + Arrays.asList(args));
			result = joinPoint.proceed(args);
			System.out.println("环绕通知--返回：name" + name + "  result:" + result);
		} catch (Throwable e) {
			System.out.println("环绕通知--异常：name" + name + "  exception:" + e);
		} finally {
			System.out.println("环绕通知--最终：name" + name + "  args:" + Arrays.asList(args));
		}
		return result;
	}
}
