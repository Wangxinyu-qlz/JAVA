package web.json.entity;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 21:40
 * @description:
 **/
public class Dog {
	private String name;
	private String address;

	public Dog(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Dog() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
