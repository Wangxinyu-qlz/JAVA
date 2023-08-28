import java.rmi.Naming;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class WrapperVSString {
	public static void main(String[] args) {
//		包装类（Integer）->String
		Integer i = 100;
//
		String str1 = i + "";//对i没有影响 新建了一个"100"
//		方式2
		String str2 = i.toString();
//      方式3
		String str3 = String.valueOf(i);

//		String->包装类（Integer）
		String str4 = "1234";
		Integer integer = Integer.parseInt(str4);//使用到自定装箱
		Integer integer1 = new Integer(str4);//构造器
	}
}

