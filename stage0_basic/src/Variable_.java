package src;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-07 11:07
 * @description: 为什么成员变量有默认值？
 * 先不考虑变量类型，如果没有默认值会怎样？
 * 变量存储的是内存地址对应的任意随机值，程序读取该值运行会出现意外。
 * 默认值有两种设置方式：手动和自动，根据第一点，没有手动赋值一定要自动赋值。
 * 成员变量在运行时可借助反射等方法手动赋值，而局部变量不行。
 * 对于编译器（javac）来说，局部变量没赋值很好判断，可以直接报错。
 * 而成员变量可能是运行时赋值，无法判断，误报“没默认值”又会影响用户体验，
 * 所以采用自动赋默认值。
 **/
public class Variable_ {
	private Integer a;
	private int b;
	private static int c;
	private static Integer d;
	private static double e;
	private static float f;
	private byte byt;
	short s;
	char ch;
	boolean boolean_;

	public static void main(String[] args) {
		Variable_ v = new Variable_();
		System.out.println(v.a);//null
		System.out.println(v.b);//0
		System.out.println(Variable_.c);//0
		System.out.println(Variable_.d);//null
		System.out.println(Variable_.e);//0.0
		System.out.println(Variable_.f);//0.0
		System.out.println(v.byt);//0
		System.out.println(v.s);//0
		System.out.println(v.ch);//u0000
		System.out.println(v.boolean_);//false
		if (v.boolean_) {
			System.out.println("boolean");
		}
		//int i;
		//if(i==0);//编译错误

		long l = 010;
		Long ll = 10l;//包装类要加l
		float f = 10;
		Float ff = 10.1f;//包装类要加f

		//int flag = (int)true;//boolean类型不能进行转换
		double d = 0x123;
		//byte b = 128;//byte类型是[-128, 127]，溢出了需要强转
		byte b = (byte)128;
		System.out.println(b);//-128


	}
}
