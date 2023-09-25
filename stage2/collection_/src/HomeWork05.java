import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork05 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Car1 car1 = new Car1("宝马", 200000);
		Car1 car2 = new Car1("宾利", 300000);
		ArrayList arrayList = new ArrayList();

		arrayList.add(car1);
		arrayList.add(car2);

		arrayList.remove(car1);
		System.out.println(arrayList.contains(car1));

		System.out.println(arrayList.size());

		System.out.println(arrayList.isEmpty());

		arrayList.clear();

		ArrayList list = new ArrayList();
		list.add(car1);
		arrayList.addAll(list);
		System.out.println("list_size:" + list.size());

		System.out.println(list.containsAll(list));

		arrayList.addAll(list);
		System.out.println(arrayList.size());

		arrayList.removeAll(list);
		System.out.println(arrayList.size());

		for(Object obj : list) {
			Car1 car = (Car1) obj;
			System.out.println(car);
		}

		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Object next = iterator.next();
			Car1 car = (Car1) next;
			System.out.println(car);
		}

	}
}

class Car1 {
	private String name;
	private double price;

	public Car1(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + "-" + this.price;
	}
}