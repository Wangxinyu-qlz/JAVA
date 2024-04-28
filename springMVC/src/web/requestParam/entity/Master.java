package web.requestParam.entity;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 12:30
 * @description:
 **/
public class Master {
	private int id;
	private String name;
	private Pet pet;

	public Master() {
	}

	public Master(int id, String name, Pet pet) {
		this.id = id;
		this.name = name;
		this.pet = pet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Master{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pet=" + pet +
				'}';
	}
}
