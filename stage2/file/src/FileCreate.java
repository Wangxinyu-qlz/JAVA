import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class FileCreate {
	public static void main(String[] args) {

	}

//	方式1 new File(String pathname)
	@Test
	public void create01() {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\test1.txt";
		File file = new File(filePath);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	方式2 new File(File parent, String child)//根据父目录文件+子路径构建
	@Test
	public void create02() {
		File parntFile = new File("C:\\My_Code\\Java\\stage2\\file\\");
		String fileNeme = "test2.txt";
		File file = new File(parntFile, fileNeme);

		try {
			file.createNewFile();//真正创建文件
			System.out.println("创建成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//  方式3 new File(String parent, Sting child)//根据父目录+子路径创建
	@Test
	public void create03() {
		String parentPath = "C:\\My_Code\\Java\\stage2\\file\\";
		String filePath = "test3.txt";
		File file = new File(parentPath, filePath);

		try {
			file.createNewFile();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

