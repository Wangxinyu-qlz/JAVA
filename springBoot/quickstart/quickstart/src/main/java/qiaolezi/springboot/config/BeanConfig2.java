package qiaolezi.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import qiaolezi.springboot.bean.Cat;
import qiaolezi.springboot.bean.Dog;
import qiaolezi.springboot.bean.Monster;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 17:17
 * @description:
 **/
@Configuration
public class BeanConfig2 {
	@Bean()
	//@Scope("prototype")
	public Monster monster02() {
		return new Monster(20, "牛魔", 50, "牛角");
	}

	@Bean
	//只有当容器中有一个名为 monster_mayi 的Bean，才会注入该Dog Bean,否则不注入
	//TODO 和解析顺序有关，如果这里写cat01，dog01不会注入
	@ConditionalOnBean(name = "monster02")
	public Dog dog01() {
		return new Dog();
	}

	@Bean
	//容器中没有name = "monster_" 的Bean，才会注入这个Cat Bean
	@ConditionalOnMissingBean(name = "monster_")
	public Cat cat01() {
		return new Cat();
	}
}
