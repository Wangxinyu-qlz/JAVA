package json;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 17:55
 * @description:
 **/

//一个JavaBean
public class Book {
	private Integer id;
	private String name;

	public Book(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
