/**
 * @author qiaolezi
 * @version 1.0
 */
public class NUllPointerException_ {
	public static void main(String[] args) {
		String name = "qwe";
		System.out.println(name.length());//OK  3

//		String a = null;
//		System.out.println(a.length());//NullPointerException

//		int b = 3;
//		int c = 0;
//		int d = b / c;
//		System.out.println(d);//ArithmeticException

//		int[] e = new int[2];
//		System.out.println(e[2]);//ArrayIndexOutOfBoundsException

//		A b1 = new B();
//		B b2 = (B)b1;//OK
//		C c2 = (C)b1;//ClassCastException

		String f = "1234";
//		将String 转换为 Integer
		int num = Integer.parseInt(f);
		System.out.println(num);//OK

		String f1 = "lasd";
//		将String 转换为 Integer
		int num1 = Integer.parseInt(f1);
		System.out.println(num1);//NumberFormatException  不能把lasd转换为数字
	}
}

class A {}
class B extends A {}
class C extends  A {}