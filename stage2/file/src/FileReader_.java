import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class FileReader_ {
	public static void main(String[] args) {

	}

	/**
	 * 单个字符读取文件
	 */
	@Test
	public void m1() {
//		1.创建一个fileReader对象
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		FileReader fileReader = null;
		int data = 0;
		try {
			fileReader = new FileReader(filePath);
//			2.读取 循环 使用read，单个字符读取
			while((data = fileReader.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
//			关闭流
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Test
	public void m2() {
//		1.创建一个fileReader对象
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		FileReader fileReader = null;
		int readLength = 0;
		char[] buffer = new char[8];
		try {
			fileReader = new FileReader(filePath);
//			2.读取 循环 使用read，单个字符读取
			while((readLength = fileReader.read(buffer)) != -1) {
				System.out.print(new String(buffer, 0, readLength));//TODO raedLength
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
//			关闭流
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
