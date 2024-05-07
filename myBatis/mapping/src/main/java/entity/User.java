package entity;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:37
 * @description:
 **/
public class User {
	private Integer id;
	private String name;

	//因为一个user可以养多个pets，mybatis 使用集合体现这种关系
	private List<Pet> pets;

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

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	//TODO 该方法会带来麻烦 StackOverflow,
	// 输出user信息时对调用pets List<Pets> ，然后去调用Pet的toString()，
	// Pet的toString()会输出user
	// 反复调用 直到堆栈溢出
	//@Override
	//public String toString() {
	//	return "User{" +
	//			"id=" + id +
	//			", name='" + name + '\'' +
	//			", pets=" + pets +
	//			'}';
	//}
}
