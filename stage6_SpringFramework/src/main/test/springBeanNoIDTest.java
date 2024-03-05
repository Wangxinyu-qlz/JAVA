package main.test;

import main.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-05 10:39
 * @description: 如果删除beans.xml文件中bean配置的id：
 *     <bean class="main.spring.bean.Monster">
 *         <property name="monsterId" value="1"/>
 *         <property name="name" value="牛魔"/>
 *         <property name="skill" value="撼天动地"/>
 *     </bean>
 *     自动为配置的bean分配id，从0开始
 *     main.spring.bean.Monster#0
 *     main.spring.bean.Monster#1
 **/
public class springBeanNoIDTest {
	@Test
	public void getMonsterWithNoID() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("++++++++++beans.xml文件中不使用id++++++++++++");
		String[] beanNamesForTypes = ioc.getBeanFactory().getBeanNamesForType(Monster.class);
		for (String beanNamesForType : beanNamesForTypes) {
			System.out.println(beanNamesForType);
			Monster bean = ioc.getBean(beanNamesForType, Monster.class);
			System.out.println(bean);
		}
	}
}
