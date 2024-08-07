package collection;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 * 不是线程安全的
 * 元素插入和取出满足FIFO
 * 底层是链表+哈希表
 */
public class LinkedHashSet01 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Set linkedHashSet = new LinkedHashSet();
		linkedHashSet.add(new Car("奥迪", 3));
		linkedHashSet.add(new Car("奥拓", 100));
		linkedHashSet.add(new Car("法拉利", 700000));
		linkedHashSet.add(new Car("保时捷", 500000));
		linkedHashSet.add(new Car("奥迪", 3));
		linkedHashSet.add(new Car("奥迪", 100000));

		System.out.println("linkedHashSet=" + linkedHashSet);
//		1.加入和取出顺序一致
//		2.LinkedHashSet 底层维护的是一个 LinkedHashMap（是 HashMap 的子类）
//		3.LinkedHashSet 底层结构：数组+双向链表
//		4.添加第一次时，直接将 数组table 扩容到16，存放的类型是 LinkHashMap$Entry
//		5.数组是 HashMap$collection.Node[] 存放的数据/对象/元素是 LinkHashMap$Entry 类型
	}
}

class Car {
	private String name;
	private double price;

	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "collection.Car{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car) obj;
		return Double.compare(price, car.price)==0 &&
				Objects.equals(name, car.name);
	}
}