import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork07 {
	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet();

//		TODO 分析源码
//		add 方法，因为 TreeSet() 构造器没有传入Comparator接口的匿名内部类
//		所以在底层 Comparator<? super K> k = (Comparator<? super K>) key;
//		即 将 Person转为 Comparable类型
		treeSet.add(new Person1());//ClassCastException
		treeSet.add(new Person1());//ClassCastException
		treeSet.add(new Person1());//ClassCastException
//		 TODO 只有第一个可以加入，因为重写的compareTo() 方法返回0，后面的永远无法加入！！！
		System.out.println(treeSet);//[Person1@1b6d3586]
	}
}

//TODO 实现接口
class Person1 implements Comparable {

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}