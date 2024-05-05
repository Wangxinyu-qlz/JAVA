package entity;


/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-05 21:22
 * @description:
 **/
public class Person {
	private Integer id;
	private String name;
	//TODO 实现级联操作，一个人对应一个和身份证
	// 直接定义为 IdenCard 属性
	private IdenCard card;

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

	public IdenCard getCard() {
		return card;
	}

	public void setCard(IdenCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", card=" + card +
				'}';
	}
}
