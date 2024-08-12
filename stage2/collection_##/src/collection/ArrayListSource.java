package collection;

import java.util.ArrayList;

/**
 * @author qiaolezi
 * @version 1.0
 * 线程不安全
 */
public class ArrayListSource {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		1.ArrayList中维护了一个Object类型的数组elementData
//		transient Object[] elementData;
//		transient表示短暂的瞬间的，该属性不会被序列化
//		2.
		/*
		*DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}
		*public ArrayList() {
		*     this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        * }
		* */
//		3.无参构造器，初始elementData容量为0，第一次分扩容为10个，后面扩容1.5倍
//		4.有参构造器，初始elementData容量为指定大小，后面扩容为1.5倍
		ArrayList list = new ArrayList();
//		ArrayList list = new ArrayList(8);
		for(int i = 1; i <= 10; i++) {
			/*public boolean add(E e) {
				ensureCapacityInternal(size + 1);//先确定是否要扩容
				elementData[size++] = e;//然后存放
				return true;
				}
			* */
			list.add(i);
		}

		for(int i = 11; i <= 15; i++) {
			list.add(i);
		}

		list.add(100);
		list.add(200);
		list.add(null);
		list.add(null);

		list.forEach(x -> System.out.println(x));
	}
}
