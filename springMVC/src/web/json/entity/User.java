package web.json.entity;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 22:00
 * @description:
 **/
public class User {
	private String name;
	private Integer age;

	public User() {
	}

	public User(String userName, Integer age) {
		this.name = userName;
		this.age = age;
	}

	public String getUserName() {
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
