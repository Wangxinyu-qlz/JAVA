import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Generic01 {
	public static void main(String[] args) {
		Dog dog1 = new Dog("大", 5);
		Dog dog2 = new Dog("小", 1);
		Dog dog3 = new Dog("点点", 3);
		ArrayList arrayList = new ArrayList();
		arrayList.add(dog1);
		arrayList.add(dog2);
		arrayList.add(dog3);

//		假如程序员不小心添加了一只猫
//		1.不能对加入集合中的元素进行类型约束（安全隐患）
//		2.遍历的时候需要进行类型转换，如果数据量大，效率低
//		解决方案：使用泛型generic
		arrayList.add(new Cat("毛毛", 2));

		Iterator iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			Object next = iterator.next();
			Dog dog = (Dog) next;//ClassCastException: Cat cannot be cast to Dog
			System.out.println(dog.getName() + "-" + dog.getAge());
		}
	}
}

class Dog {
	private String name;
	private int age;
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class Cat {
	private String name;
	private int age;
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}