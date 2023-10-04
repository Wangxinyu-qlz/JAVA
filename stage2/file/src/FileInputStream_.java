
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 * 演示FileInputStream的使用（字节输入流 文件-->程序）
 * 单个字节读取 效率低
 * 使用read(byte[] b)
 */
public class FileInputStream_ {
	public static void main(String[] args) {

	}

	@Test
	public void readFile01() {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\test1.txt";
		int readDate = 0;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
//			从该输入流读取一个字节的数据，如果没有输入可用，此方法被阻止
//			返回-1表示文件读取完毕
			while((readDate = fileInputStream.read()) != -1) {
				System.out.print((char)readDate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			TODO 关闭流 释放资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Test
	public void readFile02() {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\test1.txt";
//		字节数组
		byte[] buf  = new byte[8];
		int readLength = 0;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
//			从该输入流读取最多b.length字节的数据到字节数组，此方法将阻塞，直到某些输入可用
//			返回 -1 表示 文件读取结束
//			如果读取正常，返回实际读取的字节数
			while((readLength = fileInputStream.read(buf)) != -1) {
				System.out.print(new String(buf, 0, readLength));//转换为字符显示
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			TODO 关闭流 释放资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
