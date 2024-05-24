package entity;

import java.util.Date;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 09:14
 * @description:
 **/
public class Monster {
	//属性和表字段对应
	private Integer id;
	private Integer age;
	private String name;
	private String email;
	private Integer gender;
	private Double salary;
	private Date birthday;

	public Monster() {
	}

	public Monster(Integer id, Integer age, String name, String email, Integer gender, Double salary, Date birthday) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.salary = salary;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Monster{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", salary=" + salary +
				", birthday=" + birthday +
				'}';
	}
}
