package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * @author qiaolezi
 * @version 1.0
 */
public class CollectionIterator {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add(new Book("a", "a1", 2.2));
		collection.add(new Book("q", "q1", 2.3));
		collection.add(new Book("s", "s1", 1.2));

		System.out.println("collection=" + collection);

//		遍历集合
//		1.先得到 集合collection对应的迭代器
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()) {//判断下面还有没有数据
//			返回下一个元素，类型是Object
			Object object = iterator.next();
			System.out.println(object);
		}
//		退出while循环后，iterator迭代器指向最后一个元素
//		iterator.next();//Error:NoSuchElementException
//		如果希望再次遍历，需要重置迭代器
		System.out.println("========第二次遍历========");
		iterator = collection.iterator();//重置迭代器
		while (iterator.hasNext()) {
			Object next =  iterator.next();
			System.out.println(next);
		}
	}
}

class Book {
	private String name;
	private String Author;
	private double price;

	public Book(String name, String author, double price) {
		this.name = name;
		Author = author;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name：" + name + "\t" +
				"Author:" + Author + '\t' +
				"price:" + price;
	}
}
