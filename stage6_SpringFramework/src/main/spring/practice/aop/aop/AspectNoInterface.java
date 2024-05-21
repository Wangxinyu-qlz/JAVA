package main.spring.practice.aop.aop;

import main.spring.myAnnotation.annotation.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;

import java.util.Arrays;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 14:44
 * @description:
 **/
@Component
@Aspect()
@Order(1)
public class AspectNoInterface {
	@Pointcut(value = "execution(public void main.spring.practice.aop.aop.Car.run())")
	public void myPointCut() {}


	@Before(value = "myPointCut()")
	public void before(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("before-name " + name + " args" + Arrays.asList(args));
	}

	@AfterReturning(value = "myPointCut()", returning = "res")
	public void afterReturning(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("afterReturning-name " + name + " args" + Arrays.asList(args) + " result:" + res);
	}

	@AfterThrowing(value = "myPointCut()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("afterThrowing-name " + name + " args" + Arrays.asList(args) + " exception:" + exception);
	}

	@After(value = "myPointCut()")
	public void after(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("after-name " + name + " args" + Arrays.asList(args) + " over");
	}
}
