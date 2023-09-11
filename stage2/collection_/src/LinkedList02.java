import java.util.LinkedList;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class LinkedList02 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(100);
		System.out.println(linkedList);

//		linkedList.remove();//删除第 0 个
		linkedList.remove(3);//删除下标为3的元素
		System.out.println(linkedList);

		linkedList.set(2, 99);
		System.out.println(linkedList);

		Object o = linkedList.get(0);
		System.out.println(o);
	}
}
