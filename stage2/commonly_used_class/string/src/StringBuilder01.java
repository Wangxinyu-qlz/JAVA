/**
 * @author qiaolezi
 * @version 1.0
 */
public class StringBuilder01 {
	public static void main(String[] args) {
//		1.StringBuilder 继承 AbstractStringBuilder 类
//		2.实现了 Serializable，StringBuilder对象可以串行化（网络传输 保存到文件）
//		3.StringBuilder是final类，不能被继承
//		4.StringBuilder 对象字符序列存放在其父类 AbstractStringBuilder的 char[] value;
//		因此，字符序列存放是在堆中
//		5.没有线程同步，在多线程中使用有风险。没有synchronized 关键字，在单线程下使用
		StringBuilder stringBuilder = new StringBuilder();
	}
}

