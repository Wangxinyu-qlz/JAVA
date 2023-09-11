import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork01 {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add(new Dog("q", 1));
		collection.add(new Dog("w", 2));
		collection.add(new Dog("E", 3));

		Iterator iterator = collection.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println(obj);
		}

		iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object next =  iterator.next();
			System.out.println(next);
		}

		for (Object obj: collection) {
			System.out.println(obj);
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

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "姓名：" + name + "年龄：" +age;
	}
}
