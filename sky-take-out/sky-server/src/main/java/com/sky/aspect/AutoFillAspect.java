package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static com.sky.constant.AutoFillConstant.*;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-11 14:54
 * @description:
 **/
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
	/**
	 * 定义切入点
	 * 只有mapper包下的 添加了 AutoFill 注解的方法才进行拦截
	 */
	@Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
	public void autoFillPointCut() {
	}

	/**
	 * 前置通知，进行公共字段的赋值
	 */
	@Before("autoFillPointCut()")
	public void autoFill(JoinPoint joinPoint) {
		log.info("开始进行公共字段的填充");
		//获取当前被拦截的方法的数据库操作类型
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();//方法签名对象
		AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
		OperationType operationType = autoFill.value();
		//获取方法的参数，实体对象(菜品，员工)
		Object[] args = joinPoint.getArgs();//约定：将实体对象作为第一个参数
		if (args == null || args.length == 0) {
			return;
		}
		Object entity = args[0];
		//准备数据 时间，登录用户的数据
		Long userId = BaseContext.getCurrentId();
		LocalDateTime now = LocalDateTime.now();
		//为实体对象的公共属性进行赋值
		if(operationType == OperationType.INSERT) {
			//为4个公共字段赋值
			try {
				Method setCreateTime = entity.getClass().getDeclaredMethod(SET_CREATE_TIME, LocalDateTime.class);
				Method setCreateUser = entity.getClass().getDeclaredMethod(SET_CREATE_USER, Long.class);
				Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
				Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);

				setCreateTime.invoke(entity, now);
				setCreateUser.invoke(entity, userId);
				setUpdateTime.invoke(entity, now);
				setUpdateUser.invoke(entity, userId);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		} else if (operationType == OperationType.UPDATE) {
			//为2个公共字段赋值
			try {
				Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
				Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);

				setUpdateTime.invoke(entity, now);
				setUpdateUser.invoke(entity, userId);
			} catch (NoSuchMethodException  | IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
