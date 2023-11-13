import sun.util.resources.cldr.ii.CurrencyNames_ii;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Set_ {
	public static void main(String[] args) {
//		Set 接口的实现类的对象，不能存放重复的元素，可以添加一个null
//		Set 接口的对象，存放数据是无序的（添加和取出的顺序不一样）
//		取出的顺序是固定的
		Set set = new HashSet();
		set.add("1");
		set.add("2");
		set.add("1");
		set.add("3");
		set.add(null);
		set.add(null);
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
