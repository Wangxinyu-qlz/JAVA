package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaolezi
 * @version 1.0
 * ArrayList不保证线程安全
 * 操作时间复杂度：
 *  增：头增：O(n) 尾增：不扩容O(1) 扩容O(n) 指定位置 O(n)
 *  删：头删：O(n) 尾删：O(1)              指定位置 O(n)
 */
public class List_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		System.out.println("list=" + list);//lsit=[a, b]

//		索引从0开始
		System.out.println(list.get(0));//a

//		在索引为1的位置插入
		list.add(1, "hanmeimei");
		System.out.println("list=" + list);//lsit=[a, hanmeimei, b]

		List list2 = new ArrayList();
		list2.add("A");
		list2.add("B");
		list.addAll(list2);
		System.out.println("list=" + list);//lsit=[a, hanmeimei, b, A, B]
//		使用add方法添加一个数组，会将数组作为一个元素添加
		list.add(3, list2);
		System.out.println("list=" + list);//list=[a, hanmeimei, b, [A, B], A, B]
		list.addAll(3, list2);
		System.out.println("list=" + list);//list=[a, hanmeimei, b, A, B, [A, B], A, B]

		System.out.println(list.indexOf("A"));//3
		System.out.println(list.lastIndexOf("A"));//6

		list.remove("A");//删除第一个“A”
		System.out.println("list=" + list);//lsit=[a, hanmeimei, b, B, [A, B], A, B]
		list.remove(3);
		System.out.println("list=" + list);//lsit=[a, hanmeimei, b, [A, B], A, B]

		list.set(3, "DDD");
		System.out.println("list=" + list);//list=[a, hanmeimei, b, DDD, A, B]

//		TODO [0, 2)
		List list1 = list.subList(0, 2);
		System.out.println("subList=" + list1);//subList=[a, hanmeimei]
	}
}
