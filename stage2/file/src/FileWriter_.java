import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class FileWriter_ {
	public static void main(String[] args) {

	}

	@Test
	public void m1() {
//		1.创建一个FileWriter对象
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath, true);
			fileWriter.write('H');
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
//			TODO 对于FileWriter 一定要close()或flush()，才能写入文件
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Test
	public void m2() {
//		1.创建一个FileWriter对象
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story.txt";
		FileWriter fileWriter = null;
		char[] chars = {'\n', 'a', 'b', 'c'};
		try {
			fileWriter = new FileWriter(filePath, true);
			fileWriter.write('H');
//			fileWriter.write(chars);
//			fileWriter.write("今天晚上吃什么？".toCharArray(), 1, 3);
//			fileWriter.write("明天早上几点起？");
//			fileWriter.write("猫猫好可爱啊~", 3, 2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
//			TODO 对于FileWriter 一定要close()或flush()，才能写入文件
			if(fileWriter != null) {
				try {
//					fileWriter.flush();
//					等价于 flush() + 关闭
					fileWriter.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
