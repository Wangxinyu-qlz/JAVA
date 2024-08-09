import java.util.Arrays;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-08 13:04
 * @description:
 **/
public class SystemArrayCopy {
	public static void main(String[] args) {
		//TODO String不可变
		//public final class String
	    //implements java.io.Serializable, Comparable<java.lang.String>, CharSequence {
	    //private final char value[];
		//String类不可继承，不会有子类持有String的属性并直接或者间接修改属性
		//char数组被private final修饰，不会被直接访问，堆上数据的引用地址不可变，
		// 并且在String类的所有方法中都没有修改堆上数组中的元素
		// （final修饰数组，引用不可变，但是可以直接更改其元素）

		//栈:
		//s1 -----> 数组对象 -----> [引用1, 引用2, 引用3]
		//
		//堆:
		//数组对象:
		//- 长度: 3
		//- 元素: [引用1, 引用2, 引用3]
		//字符串常量池:
		//"1" -----> 字符串对象
		//所有数组元素引用的字符串对象 "1" 都存储在字符串常量池中，
		// 因此它们都指向同一个内存位置。
		// 数组对象和字符串对象则存储在堆上，
		// s1 变量存储在栈上。
		String[] s1 = new String[]{"1", "2", "3"};
		String[] s2 = new String[s1.length];
		//TODO 浅拷贝：只拷贝对象的引用而非对象本身
		System.arraycopy(s1, 0, s2, 0, s1.length);

		//TODO 这里不是将s1[2]的值改为"12"，而是重新指向了一个新的字符串对象
		s1[2] = "1";
		//[1, 2, 1]
		System.out.println(Arrays.toString(s1));
		//[1, 2, 3]
		System.out.println(Arrays.toString(s2));
	}
}
