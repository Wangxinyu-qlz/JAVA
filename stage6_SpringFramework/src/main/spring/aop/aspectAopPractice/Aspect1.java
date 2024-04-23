package main.spring.aop.aspectAopPractice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 10:05
 * @description:
 **/
@Aspect
@Component
public class Aspect1 {
	@Pointcut(value = "execution(* *.*(..)) && args(a, b)")
	public void p(int a, int b) {
	}

	@Before(value = "execution(* *.*(..)) && args(a, b)", argNames = "joinPoint,a,b")//TODO 这里和切面方法的参数一致
	public void showConfig(JoinPoint joinPoint, int a, int b) {
		String name = joinPoint.getSignature().getName();
		System.out.println("showConfig:function-" + name + "args-" + a + " " + b);
	}

	@AfterReturning(value = "execution(* *.*(..))", argNames = "joinPoint,result", returning = "result")
	public void showSuccessInfo(JoinPoint joinPoint, Object result) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("showSuccessInfo:function-" + name + "args-" + Arrays.asList(args) + "   result=" + result);
	}

	@AfterThrowing(value = "execution(public float *.*(..))", argNames = "joinPoint,exception", throwing = "exception")
	public void showException(JoinPoint joinPoint,Throwable exception) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("showException:function-" + name + "args-" + Arrays.asList(args) + "   exception=" + exception);
	}

	@After(value = "execution(* *.*(..)) && args(a, b)", argNames = "joinPoint,a,b")
	public void finallyInfo(JoinPoint joinPoint, int a, int b) {
		String name = joinPoint.getSignature().getName();
		System.out.println("finallyInfo:function-" + name + "args-" + a + " " + b);
	}
}
