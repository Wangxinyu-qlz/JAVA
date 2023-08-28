import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Arrays01 {
	public static void main(String[] args) {
		Integer[] integers = new Integer[5];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = (int)(2 + Math.random() * 20);
		}

		System.out.println(Arrays.toString(integers));

//		1.可以直接使用冒泡排序，也可以直接使用Arrays提供的sort方法
//		2.数组是引用类型，通过sort排序之后，会影响到实参 integers
//		3.sort重载，通过传入一个接口 Comparator 实现定制排序
//		4.调用 sort 排序方法时，传入两个参数：
//		(1)待排序数组 (2)实现了Comparator接口的匿名内部类，要求实现 compare 方法
//		这里体现了接口编程的方式

//		Arrays.sort(integers);//默认排序方法 从小到大

		//返回的值大于还是小于0，会影响排序结果，充分体现了接口编程+动态绑定+匿名内部类的综合使用
//		底层框架和源码的使用方式，很常见
		Arrays.sort(integers, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
//				TODO
//				return i1 - i2;//从小到大
				return i2 - i1;//从大到小
			}
		});
		System.out.println(Arrays.toString(integers));
	}
}
