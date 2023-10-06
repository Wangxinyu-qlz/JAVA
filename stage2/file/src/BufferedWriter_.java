import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class BufferedWriter_ {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
//		插入一个换行符，会根据当前系统（Windows/Linux）自动适配
		bufferedWriter.newLine();
		bufferedWriter.write("今天又断网了，服了！");

		bufferedWriter.close();
	}
}
