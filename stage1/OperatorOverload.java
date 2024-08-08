/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-08 14:10
 * @description:
 * String + += 运算符重载 jvm 字节码
 **/
public class OperatorOverload {
	public static void main(String[] args) {
		/*
	    Code:
	      stack=1, locals=2, args_size=1
	         0: ldc           #7                  // String ab 解释：这里编译器会在编译时优化，直接将ab字符串保存在常量池中，之后从常量池中取出，然后入栈
	         2: astore_1                          // 解释：这里将ab出栈，然后赋值给变量str
	         3: return
		 */
		//String str = "a" + "b";


		/*
		java8:
		 0: ldc           #2                  // String 1  解释：LDC cst：将常量池偏移量为cst的值入栈，譬如LDC #12，在操作栈中会占用1个字长
		 2: astore_1                          //解释：将栈顶的String 1赋值给第一个变量a
		 3: new           #3                  // class java/lang/StringBuilder 解释：创建对象，并将该对象入栈顶
		 6: dup                               // 解释：复制栈顶数据StringBuilder。因为方法调用会弹出参数(这里是Object对象)，因此需要上面的dup指令，保证在调用构造函数之后栈顶上还是 Object对象的引用，很多种情况下dup指令都是为这个目的而存在的。
		 7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V 解释：调用StringBuilder构造方法
		 10: ldc           #5                  // String 2 解释：将String 2压入栈顶
		 12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：栈顶2出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
		 15: aload_1                           // 解释：将变量a的1入栈
		 16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：将变量a的1出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
		 19: ldc           #7                  // String 3 解释：将常量池中的字符串3入栈
		 21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：将字符串3出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
		 24: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String; 解释：调用StringBuilder.toString
		 27: astore_2                          // 解释：将返回值保存在变量b
		 28: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream; 解释：获得静态变量，System.out
		 31: aload_2                           // 解释：变量2入栈
		 32: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V // 解释：变量2出栈，作为println的方法
		 35: return                            // 解释：返回void
		 */
		/*
		java19:
	         0: ldc           #7                  // 将常量池偏移量为 7 的值（字符串 "1"）加载到操作数栈顶。ldc（Load Constant）：用于将一个常量（字符串、int、float 等）从常量池中推送到栈顶。
	         2: astore_1                          // 将栈顶的值（字符串 "1"）存储到局部变量表的第 1 个位置（对应变量 a）。astore_1：将引用类型变量从操作数栈顶保存到局部变量表索引 1 处。
	         3: aload_1                           // 将局部变量表索引 1 处的值（字符串 "1"）加载到操作数栈顶。aload_1：加载引用类型变量到栈顶。
	         4: invokedynamic #9,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
	         9: astore_2                          // 将栈顶的值（拼接结果）存储到局部变量表的第 2 个位置（对应变量 b）。
	        10: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream; 将静态字段 java/lang/System.out（标准输出流）加载到操作数栈顶。getstatic获取静态字段的值并压入栈顶。
	        13: aload_2                           // 将局部变量表索引 2 处的值（拼接后的字符串）加载到操作数栈顶。
	        14: invokevirtual #19                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V 调用 java/io/PrintStream.println 方法，输出拼接后的字符串。
	        17: return
		*/
		//会调用 StringBuilder 进行拼接操作
		//TODO 在进行字符串拼接时，尽量避免使用 变量
		//String a = "1";
		//String b = "2" + a + "3";
		//System.out.println(b);


		/*
		jav8:
		 0: ldc           #2                  // String 解释：将常量空字符串入栈
		 2: astore_1                          // 解释：将空字符串赋值给a
		 3: iconst_0                          // 解释：将常量integer 0入栈
		 4: istore_2                          // 解释：出栈0，赋值给变量0
		 5: iload_2                           // 解释：将变量i=0，入栈
		 6: iconst_3                          // 解释：将integer 3入栈
		 7: if_icmpge     36                  // 解释：比较栈顶两个元素，如果相等则跳转到36
		 10: new           #3                  // class java/lang/StringBuilder 创建StringBuilder，并入栈
		 13: dup                               // 解释：复制栈顶
		 14: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V  // 解释：出栈调用StringBuilder的构造方法
		 17: aload_1                           // 解释：入栈空字符串
		 18: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 出栈空字符串，出栈StringBuilder，执行append方法
		 21: ldc           #6                  // String 1 解释：常量1入栈
		 23: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 出栈字符串1，调用append方法
		 26: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String; 出栈StringBuilder，调用append方法，将结果入栈
		 29: astore_1                          // 解释：出栈""+1，保存到变量a
		 30: iinc          2, 1                // 解释：将变量i，递增1
		 33: goto          5                   // 解释：跳转到步骤5
		 36: return                            //解释：返回
		 */
		/*
		java19:
		     0: ldc           #7                  // String
	         2: astore_1
	         3: iconst_0
	         4: istore_2
	         5: iload_2
	         6: iconst_3
	         7: if_icmpge     23
	        10: aload_1
	        11: invokedynamic #9,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
	        16: astore_1
	        17: iinc          2, 1
	        20: goto          5
	        23: return
		 */
		//long s = System.currentTimeMillis();
		//String fora = "";
		//for (int i = 0; i < 10000000; i++) {
		//    //TODO 会创建多个stringBuilder对象
		//	//此处idea会提示使用for外部StringBuilder优化
		//	fora += "1";
		//}
		//System.out.println(System.currentTimeMillis() - s);
		//System.out.println(fora);

		/*
		java19:
			 0: new           #7                  // class java/lang/StringBuilder
	         3: dup
	         4: invokespecial #9                  // Method java/lang/StringBuilder."<init>":()V
	         7: astore_1
	         8: iconst_0
	         9: istore_2
	        10: iload_2
	        11: iconst_3
	        12: if_icmpge     28
	        15: aload_1
	        16: ldc           #10                 // String 1
	        18: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
	        21: pop
	        22: iinc          2, 1
	        25: goto          10
	        28: return
		 */
		long s = System.currentTimeMillis();
		StringBuilder fora = new StringBuilder();
		//StringBuffer fora = new StringBuffer();
		for (int i = 0; i < 10000; i++) {
			fora.append("1");
		}
		System.out.println(System.currentTimeMillis() - s);//2056
		//System.out.println(fora);

		//TODO 测试结果  java 19
		//数据量          1万     1百万      1千万     1亿   10亿
		//+=             17     60807      >10分钟
		//StringBuilder  1      7          36       240   2162
		//StringBuffer   1      22         182      1764  17355
	}
}
