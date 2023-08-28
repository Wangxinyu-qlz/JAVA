/**
 * @author qiaolezi
 * @version 1.0
 */
public class String03 {
	public static void main(String[] args) {
//		下面两条语句创建了两个对象，在常量池中。
//		s1首先指向常量池中的"haha"
//		s1 = "wuwu";语句，查找常量池中有没有"wuwu"
//		如果有直接指向，如果没有，创建后指向（不指向"haha"了）
		String s1 = "haha";
		s1 = "wuwu";

//		编译器会优化===>等价于String a = "helloabc"
//		只创建了1个对象
		String a = "hello" + "abc";

//		创建了3个对象
		String a1 = "hello";
		String b1 = "abc";
//		TODO
//		1.先创建一个 StringBuilder sb = StringBuilder()
//		2.执行 sb.append("hello");
//		3.sb.append("sbc");
//		4.String s = sb.toString()
//		最后是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
		String c1 = a1 + b1;
		String d = "helloabc";
		String e = "hello" + "abc";
		System.out.println(c1 == d);//false
		System.out.println(d == e);//true
	}
}
