package main.spring.practice.autoWiredResource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 16:14
 * @description:
 **/
@Component
public class Animal {
	//@Autowired//任意名字均可匹配，只要类型存在
	//@Resource//任意名字均可匹配，只要类型存在
	//@Resource(name = "cat1")//只有id==name才可匹配，且可在编译阶段检查出来
	@Resource(type = Cat.class)//
	private Cat cat;
	public Animal() {
		cat = new Cat();
		System.out.println(cat.getName());
	}
}
