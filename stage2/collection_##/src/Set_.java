import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 * 不是线程安全的
 * 底层是哈希表
 * 不保证元素插入和取出顺序一致
 */
public class Set_ {
	public static void main(String[] args) {
//		Set 接口的实现类的对象，不能存放重复的元素
//		不可重复性是指添加的元素按照 equals() 判断时 ，返回 false，
//		需要同时重写 equals() 方法和 hashCode() 方法。
//		可以添加一个null
//		Set 接口的对象，存放数据是无序的（添加和取出的顺序不一样）
//		取出的顺序是固定的
		Set set = new HashSet();
		set.add("1");
		set.add("2");
		boolean add = set.add("1");//false
		set.add("3");
		set.add(null);
		set.add(null);//添加失败
		set.add("dady");
		set.add("array");
		set.add("zoo");

		System.out.println(set);//[null, 1, 2, 3, array, zoo, dady]

//		遍历
//	    迭代器
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Object next =  iterator.next();
			System.out.println(next);
		}
//      foreach
		for (Object o: set) {
			System.out.println(o);
		}
//		set接口对象不能通过普通for循环获取

//		其他方法
		set.remove("3");
	}
}
