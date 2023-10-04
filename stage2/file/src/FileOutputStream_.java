import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 * 演示使用FileOutputStream 将数据写入文件
 * 如果该文件不存在，则创建该文件
 */
public class FileOutputStream_ {
	public static void main(String[] args) {

	}

	@Test
	public void writeFile() {
//		创建对象
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\test4.txt";
		FileOutputStream fileOutputStream = null;

		try {
//			new FileOutputStream(filePath) 写入内容会覆盖原来内容
//			new FileOutputStream(filePath, append=true)  追加模式
			fileOutputStream = new FileOutputStream(filePath, true);
//			写入字节
			fileOutputStream.write('H');
//			写入字符串
			String str = "hello,world";
//			TODO str.getBytes() 将字符串 -> 字节数组
			fileOutputStream.write(str.getBytes());
			fileOutputStream.write(str.getBytes(), 0, 6);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
