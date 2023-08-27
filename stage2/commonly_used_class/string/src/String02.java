/**
 * @author qiaolezi
 * @version 1.0
 */
public class String02 {
	public static void main(String[] args) {
//		先从常量池查看是否有"qwe"数据空间，如果有，直接指向；如果没有，重新创建然后指向。
//		s1最终指向     常量池的地址空间
		String s1 = "qwe";
//		现在堆中创建空间，堆中维护了value属性，指向常量池的"qwe"空间。
//		如果常量池没有"qwe"，重新创建，如果有，直接通过value指向。
//		s2最终指向的    堆中的地址空间
		String s2 = new String("qwe");
		String s3 = "qwe";

		System.out.println(s1.equals(s2));//true
		System.out.println(s1 == s2);//false
		System.out.println(s1 == s3);//true
//		inter()方法最终返回的是常量池的地址（对象）
//		s1指向常量池的地址  s2指向堆中的地址
		System.out.println(s1 == s2.intern());//true
		System.out.println(s2 == s2.intern());//false


		Person p1 = new Person();
		p1.name = "qqq";
		Person p2 = new Person();
		p2.name = "qqq";

		System.out.println(p1.name.equals(p2.name));//true
//		p1->堆中Person1(p1.name)  p2->堆中Person2(p2.name)
//		TODO p1.name和p2.name指向常量池中的同一个常量"qqq"
		System.out.println(p1.name == p2.name);//true
		System.out.println(p1.name == "qqq");//true
	}
}

class Person {
	public String name;
}

