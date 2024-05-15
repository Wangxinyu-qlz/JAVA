package main.spring.practice;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 21:13
 * @description:
 **/
public class Cat {
	private String name;
	private Integer age;
	public Cat(){}

	public Cat(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
