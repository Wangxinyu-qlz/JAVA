package base;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Cat {
	private String name = "招财";
	public int age = 2;
	public Cat() {}
	public Cat(String name) {
		this.name = name;
	}

	public void hi() {
		//System.out.println("hi，我是招财猫");
	}

	public void cry() {
		System.out.println("吐了...");
	}

}
