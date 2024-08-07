package collection;

import java.util.*;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-06 15:42
 * @description:
 **/
public class Comparator_ {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			double e = Math.random() * 8 + 1;
			arrayList.add((int) e);
		}
		System.out.println("原始数组：");
		System.out.println(arrayList);
		//reverse
		Collections.reverse(arrayList);
		System.out.println("Collections.reverse(arrayList):");
		System.out.println(arrayList);

		//void sort(List list),按照自然排序的升序排序
		Collections.sort(arrayList);
		System.out.println("Collections.sort(arrayList):");
		System.out.println(arrayList);

		//定制排序
		Collections.sort(arrayList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("定制排序后：");
		System.out.println(arrayList);

		System.out.println("重写compareTo()：");
		TreeMap<PersonC, String> treeMap = new TreeMap<>();
		treeMap.put(new PersonC("a", 12), "a");//添加成功
		treeMap.put(new PersonC("b", 13), "b");//添加成功
		treeMap.put(new PersonC("b", 19), "b");//添加成功
		treeMap.put(new PersonC("c", 14), "c");//添加成功
		treeMap.put(new PersonC("c", 14), "c1");//添加不进去
		treeMap.put(new PersonC("c", 20), "c1");//添加成功
		treeMap.put(new PersonC("d", 14), "c");//添加不进去
		Set<PersonC> keys = treeMap.keySet();
		for (PersonC key : keys) {
			System.out.print(key.getAge() + "-" + key.getName());
			System.out.println("---" + treeMap.get(key));
		}
	}
}


class PersonC implements Comparable<PersonC> {
	private String name;
	private Integer age;

	//TODO重写compareTo() 实现按照年龄排序
	@Override
	public int compareTo(PersonC o) {
		if (this.age > o.getAge()) {
			return 1;
		}
		if (this.age < o.getAge()) {
			return -1;
		}
		return 0;
	}


	public PersonC(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}