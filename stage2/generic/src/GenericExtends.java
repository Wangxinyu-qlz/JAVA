import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class GenericExtends {
	public static void main(String[] args) {
		Object o = new String("xx");

//		泛型没有继承性
//		List<Object> list = new ArrayList<String>();

//		举例说明下列3个方法的使用
		List<Object> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<A1> list3 = new ArrayList<>();
		List<B1> list4 = new ArrayList<>();
		List<C1> list5 = new ArrayList<>();

//		接受任意泛型类型
		printCollection1(list1);
		printCollection1(list2);
		printCollection1(list3);
		printCollection1(list4);
		printCollection1(list5);

//		接受A1或其子类
//		printCollection2(list1);//Error
//		printCollection2(list2);//Error
		printCollection2(list3);//A1
		printCollection2(list4);//B1
		printCollection2(list5);//C1

//		接受A1或其父类
		printCollection3(list1);//Object
//		printCollection3(list2);//String
		printCollection3(list3);//A1
//		printCollection3(list4);//B1
//		printCollection3(list5);//C1

	}

//	List<?> 表示 任意泛型类型都可以接受
	public static void printCollection1(List<?> c) {
		for (Object object : c) {
			System.out.println(object);
		}
	}

//	List<? extends A1> 表示 上限，可以接受 A1或者A1的子类
//	规定了泛型的上限
	public static void printCollection2(List<? extends A1> c) {
		for (Object object : c) {
			System.out.println(object);
		}
	}

//	List<? super A1> 表示 下限，可以接受 A1或A1的父类
//	规定了泛型的下限
	public static void printCollection3(List<? super A1> c) {
		for (Object object : c) {
			System.out.println(object);
		}
	}
}

class A1 {

}

class B1 extends A1 {

}

class C1 extends B1 {

}


