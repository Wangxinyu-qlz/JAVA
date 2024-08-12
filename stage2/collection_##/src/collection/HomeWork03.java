package collection;

import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork03 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		ArrayList是线程不安全的，效率高但是不要在多线程中使用
//		List list = new ArrayList<>();
//		List list = new LinkedList();
		List list = new Vector();
		list.add(new Book("Q", "q1", 1));
		list.add(new Book("W", "w1", 5));
		list.add(new Book("T", "t1", 3));

		bubleSort(list);

		for (Object o : list) {
			System.out.println(o);
		}

	}

	@SuppressWarnings({"all"})
	public static void bubleSort(List list) {
		int listSize = list.size();
		double temp;
		for (int i = 0; i < listSize - 1; i++) {
			for (int j = 0; j < listSize - i - 1; j++) {
//				TODO 取出对象 转型
				Book book1 = (Book)list.get(i);
				Book book2 = (Book)list.get(i + 1);
//				double price1 = book1.getPrice();
//				double price2 = book2.getPrice();
//				if(price1 > price2) {
//					temp = price1;
//					price1 = price2;
//					price1 =temp;
//				}
//				TODO 使用set方法进行交换
				if(book1.getPrice() > book2.getPrice()) {
					list.set(i, book2);
					list.set(i + 1, book1);
				}
			}
		}
	}

}
