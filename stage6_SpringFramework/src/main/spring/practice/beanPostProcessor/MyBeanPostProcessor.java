package main.spring.practice.beanPostProcessor;

import main.spring.practice.bean.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 11:04
 * @description: TODO
 * 1.怎么执行到这个方法?=> 使用 AOP(反射+动态代理+IO+容器+注解)
 * 2、有什么用？=> 可以对 IOC 容器中所有的对象进行统一处理 ,比如 日志处理/权限的校验/安全的验证/事务管理.
 * 3、针对容器的所有对象吗? 是的=>切面编程特点
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before bean post process");
		((Cat)bean).setName("宝宝");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after bean post process");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
