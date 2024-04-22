package main.spring.aop.xml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 19:19
 * @description: 使用xml配置该切面类
 **/
public class SmartAnimalAspect {
	public void showBeginLog(JoinPoint joinPoint) {
		//得到方法签名
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("SmartAnimalAspect切面类showBeginLog()-方法执行前-日志--方法名-" + name
				+ "-参数-" + Arrays.asList(args));
	}

	public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showSuccessEndLog()-方法执行正常结束-日志-方法名-" + name + "-返回结果-" + res);
	}

	public void showExceptionEndLog(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showExceptionEndLog()-方法执行异常-日志-方法名-" + name + exception);
	}

	public void showFinallyEndLog(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("SmartAnimalAspect切面类showFinallyEndLog()-方法最终执行完毕-日志-方法名-" + name);
	}
}
