package main.spring.practice.autoWiredResource;

import org.springframework.stereotype.Component;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 16:14
 * @description:
 **/
@Component(value = "cat1")
public class Cat {
	private String name = "tom";
	public Cat() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
