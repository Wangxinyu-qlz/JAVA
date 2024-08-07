
/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-07 14:49
 * @description:
 * 区别点              重载方法       重写方法
 * 发生范围            同一个类        子类
 * 参数列表            必须修改        一定不能修改
 * 返回类型            可修改          子类方法返回值类型应比父类方法返回值类型更小或相等
 * 异常               可修改          子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等
 * 访问修饰符          可修改          子类访问范围 >= 父类
 * 发生阶段            编译期                   运行期
 *
 * 方法的重写要遵循“两同两小一大”（以下内容摘录自《疯狂 Java 讲义》，issue#892open in new window ）：
 * “两同”即方法名相同、形参列表相同；
 * “两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，
 * 子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；
 * “一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。
 *
 * ⭐️ 关于 重写的返回值类型 ：
 *    如果方法的返回类型是 void 和基本数据类型，则返回值重写时不可修改。
 *    但是如果方法的返回值是引用类型，重写时是可以返回该引用类型的子类的。
 **/
public class Override {
	public static void main(String[] args) {
		Son son = new Son();
		System.out.println(son.ops(1));//1
		System.out.println(son.ops(1, 1));//0
		System.out.println(son.ops(1, 1, 1));//3

		Father father = new Father();
		System.out.println(father.ops(1, 1));//2

		Father father1 = new Son();
		Son son1 = (Son) father1;
		System.out.println(son1);
		System.out.println(son1.ops(1));//1
		System.out.println(father1.ops(1, 1));//0


		System.out.println("变长参数：");
		Son son2 = new Son();
		String m = son2.m("1", "23");//优先固定参数方法
		System.out.println(m);
	}
}

class Father {
	public int ops(int i, int j) {
		return i + j;
	}

	//TODO 返回类型不同，方法签名相同（方法名和参数列表），是绝对不允许的
	//public long ops(int i, int j) {return 0L;}

	public int ops(int i, int j, int z) {
		return i + j + z;
	}
}

class Son extends Father{
	public int ops(int i) {
		return i;
	}

	@java.lang.Override
	public int ops(int i, int j) {
		return i - j;
	}

	String m(String... s) {
		System.out.println("可变长");
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<s.length; i++) {
			stringBuilder.append(s[i]);
		}
		return stringBuilder.toString();
	}

	String m(String s, String t) {
		System.out.println("普通");
		return s + t;
	}
}
