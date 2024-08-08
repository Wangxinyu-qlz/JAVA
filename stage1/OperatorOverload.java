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
		Compiled from "StringD.java"
		public class com.owl.zookeeper.string.StringD {
            public com.owl.zookeeper.string.StringD();
                Code:
                    0: aload_0
                    1: invokespecial    #1  // Method java/lang/Object."<init>":()V
                    4: return

            public static void main(java.lang.String[]);
                Code:
	                0: ldc              #2  // String ab 解释：这里编译器会在编译时优化，直接将ab字符串保存在常量池中，之后从常量池中取出，然后入栈
	                2: astore_1             // 解释：这里将ab出栈，然后赋值给变量str
	                3: return
		}
		 */
		String str = "a" + "b";


		/*
		 Compiled from "StringAppend.java"
		 public class com.owl.zookeeper.string.StringAppend {
			 public com.owl.zookeeper.string.StringAppend();
				 Code:
					 0: aload_0  //将this入栈
					 1: invokespecial #1                  // Method java/lang/Object."<init>":()V //调用Object的构造方法
					 4: return                            //返回void

			 public static void main(java.lang.String[]);
				 Code:
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
		 }
		 */
		//会调用 StringBuilder 进行拼接操作
		//TODO 在进行字符串拼接时，尽量避免使用 变量
		String a = "1";
		String b = "2" + a + "3";


		/*
		 Compiled from "StringForAppend.java"
		 public class com.owl.zookeeper.string.StringForAppend {
			 public com.owl.zookeeper.string.StringForAppend();
				 Code:
					 0: aload_0
					 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
					 4: return

			 public static void main(java.lang.String[]);
				 Code:
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
					 36: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;      // 解释：获得对象PrintStream，入栈
					 39: aload_1                           // 入栈变量a
					 40: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V // 出栈变量a,出栈PrintStream，调用println方法
					 43: return                            //解释：返回
		 }
		 */
		//String fora = "";
		//for (int i = 0; i < 3; i++) {
		//    //TODO 会创建多个stringBuilder对象
		//	//此处idea会提示使用for外部StringBuilder优化
		//	fora += "1";
		//}

		StringBuilder fora = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			fora.append("1");
		}
	}
}
