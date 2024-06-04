package qiaolezi.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import qiaolezi.springboot.bean.Cat;
import qiaolezi.springboot.bean.Dog;
import qiaolezi.springboot.bean.Monster;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 16:37
 * @description:
 **/
//配置类，等价于配置文件
//通过@Bean注解注入bean对象
/** 1. proxyBeanMethods：代理bean 的方法  默认为true
* (1) Full(proxyBeanMethods = true)
 *   【保证每个@Bean 方法被调用多少次返回的组件都是单实例   代理方式】
* (2) Lite(proxyBeanMethods = false)
 *   【每个@Bean 方法被调用多少次返回的组件都是新创建的   非代理方式】
* (3) 特别说明: proxyBeanMethods 是在 调用@Bean 方法 才生效，因此，需要先获取
       BeanConfig 组件，再调用方法 而不是直接通过 SpringBoot 主程序得到的容器来获取 bean,
       注意观察直接通过ioc.getBean() 获取 Bean, proxyBeanMethods 值并没有生效
* (4) 如何选择: 组件依赖必须使用 Full 模式默认。如果不需要组件依赖使用 Lite 模
* (5) Lite 模 也称为轻量级模式，因为不检测依赖关系，运行速度快
* */
//注入组件，id为类型的全类名  qiaolezi.springboot.bean.Dog
@Import(value = {Dog.class, Cat.class})
@Configuration(proxyBeanMethods = true)
public class BeanConfig {
	//给容器添加一个组件
	//类型: Monster2
	//id: monster01
	//value = "monster_mayi" 指定id为monster_mayi 以此为准
	//默认为单例 singleton
	@Bean(value = "monster_mayi")
	//@Scope("prototype")
	public Monster monster01() {
		return new Monster(200, "蚂蚁", 500, "钳子");
	}

	@Bean()
	@ConditionalOnBean(name = "dog01")
	public Cat cat_test() {
		return new Cat();
	}
}
