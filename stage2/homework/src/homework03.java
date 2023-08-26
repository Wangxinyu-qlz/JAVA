/**
 * @author qiaolezi
 * @version 1.0
 */
public class homework03 {
	public static void main(String[] args) {
		new Cat().shout();
		new Dog().shout();
	}
}

abstract class Animal {
	abstract public void shout();
}

class Cat extends Animal {
	public void shout() {
		System.out.println("miao");
	}
}

class Dog extends Animal {
	public void shout() {
		System.out.println("wang");
	}
}
