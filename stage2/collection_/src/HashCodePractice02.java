import java.util.HashSet;
import java.util.Objects;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashCodePractice02 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		hashSet.add(new Person("a", 2000.0, new MyDate(1999, 1, 1)));
		hashSet.add(new Person("b", 1000.0, new MyDate(1999, 1, 1)));
		hashSet.add(new Person("b", 3000.0, new MyDate(1997, 1, 1)));

		System.out.println(hashSet);
	}
}

class Person {
	private String name;
	private double sal;
	private MyDate birthday;

	public Person(String name, double sal, MyDate birthday) {
		this.name = name;
		this.sal = sal;
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, birthday);
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return p.name.equals(name) && p.birthday.equals(birthday);
	}

	@Override
	public String toString() {
		return name +
				"  sal:" + sal +
				"  birthday:" + birthday;
	}
}

class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	@Override
	public boolean equals(Object obj) {
		MyDate d = (MyDate) obj;
		return year==d.year && month==d.month && day==d.day;
	}

	@Override
	public String toString() {
		return year +
				"-" + month +
				"-" + day;
	}
}
