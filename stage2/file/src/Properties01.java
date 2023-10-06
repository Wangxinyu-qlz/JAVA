import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Properties01 {
	public static void main(String[] args) throws IOException {
//		读取mysql.properties文件并得到ip user password

		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\My_Code\\Java\\stage2\\file\\mysql.properties"));
		String line = "";
		while((line = bufferedReader.readLine()) != null) {
			String[] split = line.split("=");
			if("ip".equals(split[0])) {
				System.out.println(split[0] + "：" + split[1]);
			}
		}
		bufferedReader.close();
	}
}
