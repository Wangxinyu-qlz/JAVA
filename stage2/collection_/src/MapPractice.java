import javax.jws.WebResult;
import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class MapPractice {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Map map = new HashMap();

		Employee1 aaa = new Employee1("aaa", 20000, 1);
		Employee1 bbb = new Employee1("bbb", 50000, 2);
		Employee1 ccc = new Employee1("ccc", 14000, 3);

		map.put(aaa.getId(), aaa);
		map.put(bbb.getId(), bbb);
		map.put(ccc.getId(), ccc);

		Set keySet = map.keySet();
		for(Object key : keySet) {
			Employee1 e = (Employee1) map.get(key);
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}
		System.out.println("================");
		Iterator iterator = keySet.iterator();
		while(iterator.hasNext()) {
			Object key = iterator.next();
			Employee1 e = (Employee1) map.get(key);
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}

		System.out.println("================");
		Collection values = map.values();
		for(Object value : values) {
			Employee1 e = (Employee1) value;
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}
		System.out.println("=============");
		Iterator iterator1 = values.iterator();
		while (iterator1.hasNext()) {
			Object value =  iterator1.next();
			Employee1 e = (Employee1) value;
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}

		System.out.println("==============");
		Set entrySet = map.entrySet();
		for(Object obj : entrySet) {
			Map.Entry m = (Map.Entry) obj;
			Employee1 e = (Employee1) m.getValue();
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}

		System.out.println("============");
		Iterator iterator2 = entrySet.iterator();
		while (iterator2.hasNext()) {
			Object next =  iterator2.next();
			Map.Entry m = (Map.Entry) next;
			Employee1 e = (Employee1) m.getValue();
			if(e.getSalary() > 18000) {
				System.out.println(e);
			}
		}

	}
}

class Employee1 {
	private String name;
	private double salary;
	private int id;

	public Employee1(String name, double salary, int id) {
		this.name = name;
		this.salary = salary;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name + '-' + salary + "-" + id;
	}
}
