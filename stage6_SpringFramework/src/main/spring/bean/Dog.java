package main.spring.bean;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-16 17:45
 * @description:
 **/
public class Dog {
	private Integer id;
	private String name;

	public Dog() {
		System.out.println("Dog() 无参构造器");
	}
	//@Override
	//public String toString() {
	//	return "Dog{" +
	//			"id=" + id +
	//			", name='" + name + '\'' +
	//			'}';
	//}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
