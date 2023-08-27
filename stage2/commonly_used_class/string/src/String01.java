/**
 * @author qiaolezi
 * @version 1.0
 */
public class String01 {
	public static void main(String[] args) {
//		1.jack"是字符串常量
//		2.字符串的字符使用Unicode字符编码，一个字符（字母&汉字）占用两个字节
//		3.String 类有很多构造器，常用的有：
//		    String()
//		    String(String original)
//		    String(char[] a)
//		    String(char[] a, int startIndex, int count)
//		    String(byte[] b)
//		4.String类实现了接口Serializable(String 可以序列化/串行化，在网络传输)
//		5.String实现了接口Comparable(String对象可以比较大小)
//      6.String是final类，不能被其他类继承
//		7.String中有一个属性private final char value[];用于存放字符串内容
//		8.TODO 一定要注意：value是一个final类型，不能修改（地址不可修改,value不能指向别的对象）
		String name = "jack";

		final char[] value = {'a', 'b', 'c'};
		char[] value2 = {'t', 'e', 'y'};
		value[0] = 'H';//OK
//		value = value2;//Error  Cannot assign a value to final variable 'value'
	}
}