/**
 * @author qiaolezi
 * @version 1.0
 */
public class WrapperType {
	public static void main(String[] args) {
//		int <-> Integer 装箱和拆箱
//		JDK5之前是手动装箱和拆箱

//		手动装箱 int->Integer
		int n1 = 100;
		Integer integer = new Integer(n1);
		Integer integer1 = Integer.valueOf(n1);
//		手动拆箱 Integer->int
		int i = integer.intValue();

//		JDK5之后，可以自动装箱拆箱
		int n2 = 200;
//		自动装箱 int->Integer
		Integer integer2 = n2;//底层使用Integer.valueOf(n2)
//		自动拆箱
		int n3 = integer2;//底层使用intValue()

//		其他包装类的拆箱装箱用法一致

		Double d = 100d;
		Float f = 1.2f;

		Object obj = true?new Integer(1):new Double(2.0);
		System.out.println(obj);//TODO 1.0 三元运算符是一个整体

		Object obj2;
		if(true) {
			obj2 = new Integer(1);
		} else {
			obj2 = new Double(2.0);
		}
		System.out.println(obj2);//1
	}
}

