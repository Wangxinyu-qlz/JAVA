package main.spring.aop.aspectjAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 19:19
 * @description:
 **/
@Component  //Spring容器启动时，将该类注入到容器
@Aspect  //表示是一个 切面类  自动引入 动态代理+反射+动态绑定...
//TODO 这里代表的是前置通知的优先级，其他通知类似于过滤器链式法则，1前 3前 3返回 3异常 3最终 1返回 1异常 1最终
@Order(value = 2)  //表示优先级，数字越小，优先级越高
public class SmartAnimalAspect {
	//定义一个切入点表达式，在后面直接引用，提高复用性
	@Pointcut(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))")
	public void myPointCut() {}

	/*
	 * 1.@Before 表示这个方法是一个前置通知，在目标对象的方法执行前 执行
	 * 2."execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))"
	 * 表示切入到哪个类的哪个方法，形参列表可以区分 方法重载
	 * 形式：访问修饰符 返回类型 全类名.方法名(形参列表)
	 * 3.f1()方法可以理解为一个 切入方法
	 * 4.JointPoint jointPoint 在底层执行时，由AspectJ切面框架 给切入方法传入jointPoint
	 * 通过该方法，可以获取到相关信息*/

	//@Before(value = "execution(* *.*(..))")//TODO 处理包下所有的方法
	//@Before(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.*(double, double))")//TODO 只要方法的参数列表是(double, double)就处理
	@Before(value = "myPointCut()")
	public void showBeginLog(JoinPoint joinPoint) {
		//得到方法签名
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("SmartAnimalAspect切面类showBeginLog()-方法执行前-日志--方法名-" + name
				+ "-参数-" + Arrays.asList(args));
	}

	//方法正常执行结束后 执行
	//可以使用简单类名，前提是在一个包下
	//获取目标方法的执行结果
	//1.@AfterReturning(returning="")
	//2.名称要一致
	@AfterReturning(value = "myPointCut() || execution(public double main.spring.aop.aspectjAOP.Monkey.getSub(double, double)) || execution(public double main.spring.aop.aspectjAOP.Dog.getSub(double, double))", returning = "res")
	public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showSuccessEndLog()-方法执行正常结束-日志-方法名-" + name + "-返回结果-" + res);
	}

	//方法执行出现异常后执行
	//Throwable / Exception e
	@AfterThrowing(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getDivision(int, int))", throwing = "exception")
	public void showExceptionEndLog(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showExceptionEndLog()-方法执行异常-日志-方法名-" + name + exception);
	}

	//最终通知：切入到目标方法执行后，无论是否发生异常，都要执行
	@After(value = "execution(public double main.spring.aop.aspectjAOP.Monkey.getSum(double, double))")
	public void showFinallyEndLog(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showFinallyEndLog()-方法最终执行完毕-日志-方法名-" + name);
	}

	@Before(value = "execution(public void Car.run())")
	public void ok(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类ok()-方法前-日志-方法名-" + name);
	}

	@AfterReturning(value = "execution(public void Car.run())")
	public void ok2(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类ok2()-方法成功后-日志-方法名-" + name);
	}

	@AfterThrowing(value = "execution(public void Car.run())")
	public void ok3(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类ok3()-方法执行出现异常后-日志-方法名-" + name);
	}

	//后置通知
	@After(value = "execution(public void Car.run())")
	public void ok4(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类ok4()-最终-日志-方法名-" + name);

		joinPoint.getSignature().getName();//获取方法名 run
		joinPoint.getSignature().getDeclaringType().getSimpleName();//目标方法所属类的简单类名 Car
		joinPoint.getSignature().getDeclaringTypeName();//目标方法所属类的类名 main.spring.aop.aspectjAOP.Car
		joinPoint.getSignature().getModifiers();//获取目标方法声明类型（public private protected）1
		Object[] args = joinPoint.getArgs();//参数
		joinPoint.getTarget();//被代理的对象  Car@3310
		joinPoint.getThis();//获取代理对象自己  main.spring.aop.aspectjAOP.Car$$EnhancerBySpringCGLIB$$7b774219  main.spring.aop.aspectjAOP.Car@27d5a580
	}


}
