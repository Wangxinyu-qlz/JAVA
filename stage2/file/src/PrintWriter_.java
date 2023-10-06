import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qiaolezi
 * @version 1.0
 *
 */
public class PrintWriter_ {
	public static void main(String[] args) throws IOException {
		PrintWriter printWriter = new PrintWriter(System.out);
		printWriter.print("helko");
		printWriter.close();

		PrintWriter printWriter1 = new PrintWriter(new FileWriter("C:\\My_Code\\Java\\stage2\\file\\printWriter.txt"));
		printWriter1.print("tst穆");
		printWriter1.close();
	}
}
