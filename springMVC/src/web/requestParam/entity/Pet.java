package web.requestParam.entity;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 12:30
 * @description:
 **/
public class Pet {
	private int id;
	private String name;

	public Pet() {
	}

	public Pet(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
