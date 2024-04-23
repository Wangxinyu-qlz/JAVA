package main.spring.processor_;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 12:08
 * @description: 后置处理器 TODO 会处理容器中所有bean
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * bean的初始化方法前调用
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before  " + bean.getClass());
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	/**
	 * bean的初始化方法后调用
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after  " + bean.getClass());
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
