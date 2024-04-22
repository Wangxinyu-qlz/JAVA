package main.spring.aop.aspectjAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 21:41
 * @description:
 **/
@Aspect
@Component
@Order(value = 1)
public class SmartAnimalAspect3 {
	@Before(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))")
	public void showBeginLog(JoinPoint joinPoint) {
		//得到方法签名
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("SmartAnimalAspect3切面类showBeginLog()-方法执行前-日志--方法名-" + name
				+ "-参数-" + Arrays.asList(args));
	}

	@AfterReturning(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))", returning = "res")
	public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect3切面类showSuccessEndLog()-方法执行正常结束-日志-方法名-" + name + "-返回结果-" + res);
	}

	@AfterThrowing(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))", throwing = "exception")
	public void showExceptionEndLog(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect3切面类showExceptionEndLog()-方法执行异常-日志-方法名-" + name + exception);
	}

	@After(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))")
	public void showFinallyEndLog(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect3切面类showFinallyEndLog()-方法最终执行完毕-日志-方法名-" + name);
	}
}
