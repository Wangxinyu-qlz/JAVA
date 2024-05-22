package main.spring.practice.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Aspect_no_interface {
	@Pointcut(value = "execution(public void Car.run())")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("111前置通知 name:" + name + "  args:" + Arrays.asList(args));
	}

	//returning = "res"  获取方法的返回值
	@AfterReturning(value = "pointCut()", returning = "res")
	public void afterReturning(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("111返回通知 name:" + name + "  args:" + Arrays.asList(args) + "res:" + res);
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("111异常通知 name:" + name + "  args:" + Arrays.asList(args) + "  exception:" + exception);
	}

	@After(value = "pointCut()")
	public void after(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("111最终通知 name:" + name + "  args:" + Arrays.asList(args));
	}
}
