import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class BufferedReader_ {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
//		创建BufferedReader
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		读取
		String line;//按行读取
		while((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

//		关闭流  只需要关闭bufferedReader即可，底层会自动关闭节点流 FileReader
		bufferedReader.close();
	}


}
