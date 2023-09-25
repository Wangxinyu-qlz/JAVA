import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class GenericExercise02 {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("J小王", 20000.0, new MyDate(1998, 1, 1)));
		employees.add(new Employee("A老崔", 30000.0, new MyDate(1987, 3, 10)));
		employees.add(new Employee("A老崔", 30000.0, new MyDate(1978, 1, 10)));
		employees.add(new Employee("A老崔", 30000.0, new MyDate(2001, 9, 10)));
		employees.add(new Employee("B赵四", 25000.0, new MyDate(2007, 12, 1)));
		employees.add(new Employee("B赵四", 5000.0, new MyDate(2007, 10, 8)));
		System.out.println("========foreach=========");
		for(Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println("========迭代器=========");
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		employees.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(!(o1 instanceof Employee && o2 instanceof Employee)) {
					System.out.println("类型不匹配！");
					return 0;
				}
//				if(o1.getName().equals(o2.getName())) {
//					return o1.getBirthday().getBirthday() - o2.getBirthday().getBirthday();
//				} else {
//					return o1.getName().compareTo(o2.getName());
//				}
//				比较 name
				int i = o1.getName().compareTo(o2.getName());
				if(i != 0) {
					return i;
				}
//				TODO 封装 birthDay的比较
				return o1.getBirthday().compareTo(o2.getBirthday());
			}
		});

		System.out.println("========排序=========");
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
}

class Employee {
	private String name;
	private double sal;
	private MyDate birthday;

	public Employee(String name, double sal, MyDate birthday) {
		this.name = name;
		this.sal = sal;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return name + "\t" + sal + "\t" + birthday;
	}
}

class MyDate implements Comparable<MyDate> {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getBirthday() {
		return month + day;
	}

	@Override
	public String toString() {
		return year + "/" + month + "/" + day;
	}

	@Override
	public int compareTo(MyDate o) {
//				比较 year
				int yearMinus = year - o.getYear();
				if(yearMinus != 0) {
					return yearMinus;
				}
//				比较 month
				int monthMinus = month - o.getMonth();
				if(monthMinus != 0) {
					return monthMinus;
				}
//				比较 day
				int dayMinus = day - o.getDay();
				return dayMinus;
	}
}
