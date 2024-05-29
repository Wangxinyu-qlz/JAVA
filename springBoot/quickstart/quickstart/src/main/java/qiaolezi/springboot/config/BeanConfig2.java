package qiaolezi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
