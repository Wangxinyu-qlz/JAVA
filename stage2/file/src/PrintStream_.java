import java.io.IOException;
import java.io.PrintStream;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class PrintStream_ {
	public static void main(String[] args) throws IOException {
		PrintStream out = System.out;
//		默认情况下输出到显示器
//		public void print(String s) {
//        if (s == null) {
//            s = "null";
//        }
//        write(s);
//      }
		out.print("Hello\n");
		out.write("韩天尊".getBytes());

		out.close();

//		可以修改打印流的输出位置
		System.setOut(new PrintStream("C:\\My_Code\\Java\\stage2\\file\\printStream.txt"));
		System.out.println("test测试一下");
	}
}
