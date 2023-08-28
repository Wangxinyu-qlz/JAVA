/**
 * @author qiaolezi
 * @version 1.0
 */
public class CommonUsedStringMethods {
	public static void main(String[] args) {
		System.out.println("a".equals("A"));//false
		System.out.println("a".equals("a"));//true

		System.out.println("a".equalsIgnoreCase("A"));//true

		System.out.println("a".length());//1

//		s1.indexOf(s2)：找到字符串s2在s1中出现的第一个位置并返回，没找到返回0
		System.out.println("aqwe".indexOf("qqaqwert"));//-1  没找到
		System.out.println("qqaqwert".indexOf("aqwe"));//2
		System.out.println("qqaqwert".indexOf("1234"));//-1
//		最后一次出现的位置
		System.out.println("hello qhello".lastIndexOf("hello"));//7

//		TODO 字符串截取的位置
		System.out.println("hello,world!".substring(4));//o,world!
		System.out.println("hello,world!".substring(4, 6));//o,

		System.out.println("a".toUpperCase());//A
		System.out.println("A".toLowerCase());//a

		System.out.println("a".concat("bcd").concat("qw!"));//abcdqw!

		String s1 = "hello you";
		String s2 = s1.replace("hello", "fuck");
		System.out.println(s1);//hello you TODO 不会改变原来的字符串
		System.out.println(s2);//fuck you

		String p = "1, 2, 3, 4";
		String[] pp = p.split(", ");
		for (int i = 0; i < pp.length; i++) {
			System.out.print(pp[i] + " ");//1 2 3 4
		}
		System.out.println("\n");

		String path = "C\\qwe\\q";
//		String[] pathp1 = path.split("\\");//Error
		String[] pathp2 = path.split("\\\\");//OK

		String h = "happy";
		char[] hc = h.toCharArray();
		for (int i = 0; i < hc.length; i++) {
			System.out.print(hc[i] + " ");//h a p p y
		}

//		比较长度，前者大return正数 后者大return负数 一样大return0
//		1.如果长度和内容都相同，返回0
//		2.如果长度相同或不同，但是在进行比较时，可以区分大小，返回：
//		if (c1 != c2) {return c1 - c2;}
//		3.如果前面的部分都相同，就返回：str1.len - str2.len
		System.out.println("a".compareTo("aa"));//-1
		System.out.println("aaabbb".compareTo("aa"));//4
		System.out.println("aa".compareTo("aa"));//0

		String name = "qwe";
		char gender = '男';
		int age = 33;
		String info = "姓名：" + name + "性别：" + gender + "年龄：" + age;
		System.out.println(info);

		String formatString = "姓名：%s性别：%c年龄：%d";
		String info2 = String.format(formatString, name, gender, age);
		System.out.println(info2);
	}
}
