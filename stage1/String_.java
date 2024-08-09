/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-09 12:10
 * @description:
 **/
public class String_ {
	public static void main(String[] args) {
		//str1 str2:栈/堆
		//"abc":字符串常量池（堆）
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);//true

		//str3 str4:栈/堆
		//String实例:堆
		//"hello":字符串常量池（堆）
		String str3 = new String("hello");
		String str4 = new String("Hello");
		System.out.println(str3 == str4);//false

		//array:栈/堆
		//数组：堆
		//str5:栈/堆
		//String实例:堆
		byte[] array = {97, 98, 99};
		String str5 = new String(array);
		System.out.println(str5);//abc
		array[0] = 99;
		//数组中的值已经改变，但 str5 依然是 "abc"，因为 String 在 Java 中是不可变的。
		//一旦创建了 String 对象，它的值是无法改变的。
		// str5 在创建时已经和 array 脱离了联系，修改 array 不会影响 str5。
		System.out.println(str5);//abc
		for (byte b : array) {
			System.out.println(b);//99 98 99
		}

		//array2:栈/堆
		char[] array2 = {'a', 'b', 'c'};
		String str6 = new String(array2);
		System.out.println(str6);//abc
	}
}
