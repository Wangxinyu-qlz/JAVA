/**
 * @author qiaolezi
 * @version 1.0
 */
public class Exception_Throws {
	public static void main(String[] args) throws Exception{//默认有一个抛出异常
		/*
		*                  ——>>>>调用>>>>——
		*                  |              |
		* JVM--->main--->f1()---------->f2()
		*                | |              |
		*                  -<<<throws<<<---
		* f1调用f2，f2捕获到异常后，抛出给f1，由f1处理异常
		* f1()两种选择：1.throws抛出给main()   2.try-catch-finally
		* main()两种选择：1.throws抛出给JVM    2.try-catch-finally
		* JVM：输出异常信息，中断（退出）程序
		* */
	}
}

