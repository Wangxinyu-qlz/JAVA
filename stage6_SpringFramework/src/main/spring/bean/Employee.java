package main.spring.bean;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-15 16:50
 * @description:
 **/
public class Employee {
	private String name;
	private Department department;

	public Employee(){

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", department=" + department +
				'}';
	}
}
