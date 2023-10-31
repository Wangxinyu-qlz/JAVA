package class_;

import java.io.Serializable;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class AllTypeClass {
	public static void main(String[] args) {
		Class<String> cls1 = String.class;//外部类
		Class<Serializable> cls2 = Serializable.class;//接口
		Class<Integer[]> cls3 = Integer[].class;//数组
		Class<float[][]> cls4 = float[][].class;//二维数组
		Class<Deprecated> cls5 = Deprecated.class;//注解
		Class<Thread.State> cls6 = Thread.State.class;//枚举
		Class<Long> cls7 = long.class;//基本数据类型
		Class<Void> cls8 = void.class;//返回类型
		Class<Class> cls9 = Class.class;//Class

		System.out.println(cls1);//class java.lang.String
		System.out.println(cls2);//interface java.io.Serializable
		System.out.println(cls3);//class [Ljava.lang.Integer;
		System.out.println(cls4);//class [[F
		System.out.println(cls5);//interface java.lang.Deprecated
		System.out.println(cls6);//class java.lang.Thread$State
		System.out.println(cls7);//long
		System.out.println(cls8);//void
		System.out.println(cls9);//class java.lang.Class
	}
}
