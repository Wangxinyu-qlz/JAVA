package main.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-17 15:47
 * @description: 后置处理器
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 在 Bean的初始化方法执行之前 被调用
	 * @param bean 传入的在ioc容器中配置的Bean （class=...House）
	 * @param beanName 传入的在ioc容器中配置的Bean 的ID （id="house"）
	 * @return Object： 程序员对传入的Bean进行处理（需要的话）后返回
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization()被调用，bean=" + bean + "  beanName=" + beanName);

		//AOP：如果对象类型是House，统一改为上海豪宅
		if(bean instanceof House) {
			((House)bean).setName("上海豪宅");
		}

		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);//这里就是return bean;
	}

	/**
	 * 在 Bean的初始化方法执行之后 被调用
	 * @param bean 传入的在ioc容器中配置的Bean （可能已经被前置处理器处理）
	 * @param beanName 传入的在ioc容器中配置的Bean 的ID
	 * @return Object： 程序员对传入的Bean进行处理（需要的话）后返回
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization()被调用，bean=" + bean + "  beanName=" + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
