import java.util.HashSet;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashMapIncrement {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		/*
		* 第一次添加时，table数组扩容到16
		* 临界值（Threshold）是16*loadFactor（0.75）=12
		* 如果table数组使用到了临界值12，扩容到16*2=32，
		* 临界值为32*0.75=24
		* 依次类推
		* */

		HashSet hashSet = new HashSet();
//		for (int i = 1; i <= 100; i++) {
//			hashSet.add(i);
//		}
		/*
		* 在Java8中，如果一条链表的元素个数到达 TREEIFY_THRESHOLD(8)
		* 并且table的大小 >= MIN_TREEIFY_CAPACITY(64)，就会进行树化（红黑树）
		* 否则仍然使用数组扩容机制
		* */
//		for (int i = 1; i <= 12; i++) {
//			hashSet.add(new A(i));
//		}
		System.out.println("hashSet=" + hashSet);

		/*
		* 当向hashSet中添加元素时，-> Node -> 接入table，就是增加了一个*/
		for (int i = 1; i <=7 ; i++) {//在table上的某一条链表上添加7个A对象
			hashSet.add(new A(i));
		}

		for (int i = 1; i <=7 ; i++) {//在table上的另一条链表上添加7个B对象
			hashSet.add(new B(i));
		}
	}
}

class A {
	private int n;

	public A(int n) {
		this.n = n;
	}

	@Override
	public int hashCode() {
		return 100;
	}
}

class B {
	private int n;

	public B(int n) {
		this.n = n;
	}

	@Override
	public int hashCode() {
		return 200;
	}
}