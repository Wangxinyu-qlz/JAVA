import java.util.HashSet;
import java.util.Objects;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork08 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		/*
		* 注意：
		* 这是重写 equal 和 hashcode 后的结果
		* */
		HashSet set = new HashSet();
		Person2 p1 = new Person2(1001, "AA");//OK
		Person2 p2 = new Person2(1002, "BB");//OK
		set.add(p1);//OK  p1-hashcode: 66443
		set.add(p2);//OK  p2-hashcode: 67434
		p1.name = "CC";//OK  p1-hashcode: 不变
		set.remove(p1);//通过 rename 后的p1的计算hashcode：68427 无法找到
		System.out.println(set);//[Person2@1076b, Person2@10b4a]
		set.add(new Person2(1001, "CC"));//添加到hash表中的新位置 p3-hashcode没有出现在hash表中
		System.out.println(set);//[Person2@1076b, Person2@10b4a, Person2@10b4a]
		set.add(new Person2(1001, "AA"));//挂载到hash表中p1的后面 p3-hashcode=p1-hashcode，故挂载
		System.out.println(set);//[Person2@1076b, Person2@10b4a, Person2@10b4a, Person2@1038a]
	}
}

class Person2 {
	public String name;
	public int id;

	public Person2(int id, String name) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Person2) {
			Person2 p = (Person2) obj;
			return p.name.equals(this.name) && p.id==this.id;
		}
		return false;
	}
}