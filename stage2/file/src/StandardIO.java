import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class StandardIO {
	public static void main(String[] args) {
//		System类的 public final static InputStream in = null;
//      System.in的编译类型为：InputStream
//		System.in的运行类型为：BufferedInputStream
//		表示标准输入 键盘
		System.out.println(System.in.getClass());//class java.io.BufferedInputStream

//		System类的 public final static PrintStream out = null;
//		System.out的编译类型是PrintStream
//		system.out的运行类型是PrintStream
//		表示标准输出 显示器
		System.out.println(System.out.getClass());//class java.io.PrintStream

		System.out.println("Hello, world");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入：");
		String next = scanner.next();
		System.out.println(next);
	}
}
