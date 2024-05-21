package main.spring.practice.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 11:08
 * @description:
 **/
//@Aspect()
//@Component
//@Order(3)
public class Aspects {
	@Pointcut(value = "execution(* *.getSum(double, double)) || execution(* *.getSub(double, double))")
	public void pointCut() {
	}

	@Before(value = "pointCut() || execution(* *.getDivision(int, int))")
	public void before(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("前置通知 name:" + name + "  args:" + Arrays.asList(args));
	}

	//returning = "res"  获取方法的返回值
	@AfterReturning(value = "pointCut() || execution(* *.getDivision(int, int))", returning = "res")
	public void afterReturning(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("返回通知 name:" + name + "  args:" + Arrays.asList(args) + "res:" + res);
	}

	@AfterThrowing(value = "execution(* *.getDivision(int, int))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("异常通知 name:" + name + "  args:" + Arrays.asList(args) + "  exception:" + exception);
	}

	@After(value = "execution(* *.*(..))")
	public void after(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("最终通知 name:" + name + "  args:" + Arrays.asList(args));
	}

}
