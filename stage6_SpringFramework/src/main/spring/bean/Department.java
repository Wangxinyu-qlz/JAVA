package main.spring.bean;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-15 16:49
 * @description: 部门
 **/
public class Department {
	private String name;
	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" +
				"name='" + name + '\'' +
				'}';
	}
}
