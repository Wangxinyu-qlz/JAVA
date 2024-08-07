package collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author qiaolezi
 * @version 1.0
 * 不是线程安全的
 * 用于支持对元素自定义排序
 */
public class TreeSet_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		1.当使用无参构造器创建TreeSet时，是无序的
//		2.希望添加的字符串按照字符窜大小排序
//		3.使用TreeSet提供的构造器，可以传入一个比较器（匿名内部类）
//		并指定排序规则

//		TreeSet treeSet = new TreeSet();
//		1.构造器将传入的比较器对象，赋给 TreeSet 底层的 TreeMap 属性 this.comparetor
//		2.
		TreeSet treeSet = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
//				下面 调用String的CompareTo方法，进行比较
//				return ((String) o2).compareTo((String) o1);//字母排序，无法添加内容相同的元素
				return ((String) o1).length() - ((String) o2).length();//按照长度，无法重复添加长度相同的元素
			}
		});
		treeSet.add("jack");
		treeSet.add("tom");
		treeSet.add("j");
		treeSet.add("mark");//按照长度规则，不会被添加
		treeSet.add("tom");//覆盖（Key不变，Value更新）

		System.out.println(treeSet);//[j, jack, mark, tom]

	}
}
