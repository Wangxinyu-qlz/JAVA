import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class GenericExercise01 {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
//		ArrayList<Student> students1 = new ArrayList<>();
		students.add(new Student("a", 1));
		students.add(new Student("b", 2));
		students.add(new Student("c", 3));
//		students.add(new Dog("a", 1));//Error
//		遍历
		for(Student student : students) {
			System.out.println(student.getName());
		}
//		TODO ???创建迭代器的时候，需要指定泛型的类型<Student>
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}

		HashMap<String, Student> stringStudentHashMap = new HashMap<>();
		stringStudentHashMap.put("a", new Student("a",1 ));
		stringStudentHashMap.put("b", new Student("b", 2));
		stringStudentHashMap.put("c", new Student("c", 3));
//		遍历
//		迭代器 EntrySet
		Set<Map.Entry<String, Student>> entries = stringStudentHashMap.entrySet();
		Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();
		while (iterator1.hasNext()) {
			Map.Entry<String, Student> next =  iterator1.next();
			System.out.println(next.getKey() + "-" + next.getValue());
		}
	}
}

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
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

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
