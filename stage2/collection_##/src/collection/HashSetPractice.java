package collection;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashSetPractice {
	public static void main(String[] args) {
		Employee a1 = new Employee("a", 1);
		Employee b = new Employee("b", 1);
		Employee a2 = new Employee("a", 1);
		HashSet hashSet = new HashSet();
		hashSet.add(a1);
		hashSet.add(b);
		hashSet.add(a2);

		System.out.println(hashSet);
	}
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		return e.age==age && e.name.equals(name);
	}

	@Override
	public int hashCode() {
//		TODO 根据 name 和 age 计算 hashCode
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "collection.Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
