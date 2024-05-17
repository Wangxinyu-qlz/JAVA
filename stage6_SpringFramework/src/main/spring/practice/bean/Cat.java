package main.spring.practice.bean;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 21:13
 * @description:
 **/
public class Cat {
	private String name;
	private Integer age;
	public Cat(){
		System.out.println("Cat::Constructor NULL");
	}

	public Cat(String name, Integer age) {
		this.name = name;
		this.age = age;
		System.out.println("Cat::Constructor");
	}

	public void init() {
		System.out.println("Cat init");
	}

	public void destroy() {
		System.out.println("Cat destroy");
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
