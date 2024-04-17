package main.spring.bean;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-17 15:04
 * @description:
 **/
public class House {
	private String name;
	public House() {
		System.out.println("House()构造器");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("House setName()=" + name);
		this.name = name;
	}

	//名字是根据业务逻辑写的，自定义
	public void init() {
		System.out.println("House init()..");
	}

	//名字是根据业务逻辑写的，自定义
	public void destroy() {
		System.out.println("House destroy()..");
	}

	@Override
	public String toString() {
		return "House{" +
				"name='" + name + '\'' +
				'}';
	}
}
