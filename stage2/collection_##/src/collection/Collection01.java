package collection;

import java.util.ArrayList;

/**
 * @author qiaolezi
 * @version 1.0
 * 动态保存多个对象
 * 提供add delete set get等方法
 * 使用集合添加删除新元素代码简洁
 */
public class Collection01 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		集合：单列  双列
//		Collection接口有两个重要的子接口 List Set，都是单列集合
//		Map接口的实现子类是双列集合，存放的Key-Value
		ArrayList list = new ArrayList();
		list.add("a");
		list.add(10);//自动装箱list.add(new Integer(10))
		list.add(true);
		System.out.println("list=" + list);//list=[a, 10, true]

		list.remove(0);//删除第一个元素
		list.remove("10");
		System.out.println("list=" + list);//list=[10, true]

		System.out.println(list.contains("a"));//false

		System.out.println(list.size());//2

		System.out.println(list.isEmpty());//false

		list.clear();
		System.out.println("list=" + list);//list=[]

		ArrayList list2 = new ArrayList();
		list2.add("b");
		list2.add("c");

		list.addAll(list2);
		System.out.println("list=" + list);//list=[b, c]

		System.out.println(list.containsAll(list2));//true

		list.add("qwer");
		list.removeAll(list2);
		System.out.println("list=" + list);//list=[qwer]
	}
}
