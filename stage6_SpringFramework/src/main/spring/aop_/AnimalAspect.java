package main.spring.aop_;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 12:27
 * @description:
 **/
@Aspect
@Component
public class AnimalAspect {
	@Before(value = "execution(* Dog.*(..))")
	public void showConfig(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("showConfig() 目标函数为" + name);
	}

	@AfterReturning(value = "execution(* Dog.*(..))")
	public void showSuccessInfo(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("showSuccessInfo() 目标函数为" + name);
	}

	@AfterThrowing(value = "execution(* Dog.*(..))", throwing = "exception")
	public void showExceptionInfo(JoinPoint joinPoint, Throwable exception) {
		String name = joinPoint.getSignature().getName();
		System.out.println("showExceptionInfo() 目标函数为" + name + "Exception=" + exception);
	}

	@After(value = "execution(* Dog.*(..))")
	public void showFinallyInfo(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("showFinallyInfo() 目标函数为" + name);
	}
}
