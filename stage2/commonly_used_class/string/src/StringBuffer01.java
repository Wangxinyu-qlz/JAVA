/**
 * @author qiaolezi
 * @version 1.0
 */
public class StringBuffer01 {
	public static void main(String[] args) {
//		1.StringBuffer的 直接父类 是 AbstractStringBuilder
//		2.实现了 Serializable，其对象可以串行化/序列化
//		TODO 细节
//		3.在父类中，AbstractStringBuilder 有属性 Char[] value，不是final类型
//		该 value 数组存放 字符串内容，存放在堆中
//		4.StringBuffer类是一个final类型，不能被继承
//		5.StringBuffer 字符内容存在 char[] value, 当增删内容时，不用每次都更换地址(即创建新的对象)，效率高于String

//		创建一个大小为 16 的 char[]，用于存放字符串
		StringBuffer stringBuffer = new StringBuffer();

//		直接指定容量大小
		StringBuffer stringBuffer1 = new StringBuffer(23);

//		char[] 数组大小是 16 + 字符串"hello"的长度
		StringBuffer stringBuffer2 = new StringBuffer("hello");


//		String -> StringBuffer
		String str  = "hello full";
//		方式1：使用构造器
//		注意：返回的是StringBuffer对象，对str没有影响
		StringBuffer stringBuffer3 = new StringBuffer(str);

//		使用append方法
		StringBuffer stringBuffer4 = new StringBuffer();
		stringBuffer4.append(str);

//		StringBuffer->String
		StringBuffer stringBuffer5 = new StringBuffer("qweqwe");
//		方式1： 使用StringBuffer提供的 toString 方法
		String s = stringBuffer5.toString();
//		使用构造器
		String s1 = new String(stringBuffer5);


		String sp = null;
		StringBuffer sb = new StringBuffer();
		sb.append(sp);//
		System.out.println(sb.length());//4

		System.out.println(sb);//null
		StringBuffer sb1 = new StringBuffer(sp);//NullPointerException
		System.out.println(sb1);
	}
}