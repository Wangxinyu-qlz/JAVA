package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class CollectionFor {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Collection collection = new ArrayList<>();
		collection.add(new Book("a", "a1", 2.2));
		collection.add(new Book("q", "q1", 2.3));
		collection.add(new Book("s", "s1", 1.2));

//		底层是迭代器
		for(Object book : collection) {
			System.out.println("book:" + book);
		}
	}
}
