import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Directory_ {
	public static void main(String[] args) {

	}

	public File createFile() {
		String filename = "C:\\My_Code\\Java\\stage2\\file\\test4.txt";
		File file = new File(filename);

		try {
			file.createNewFile();
			System.out.println("创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}


	@Test
	public void m1() {
		File file = createFile();
		if (file.exists()) {
			if (file.delete()) {
				System.out.println(file.getName() + "删除成功！");
			} else {
				System.out.println(file.getName() + "删除失败！");
			}
		} else {
			System.out.println("该文件不存在！");
		}
	}

	@Test
	public void m2() {
		String filename = "C:\\My_Code\\Java\\stage2\\file\\testDirectory";
		File file = new File(filename);

		try {
			file.createNewFile();
			System.out.println("创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (file.exists()) {
			if (file.delete()) {
				System.out.println(file.getName() + "删除成功！");
			} else {
				System.out.println(file.getName() + "删除失败！");
			}
		} else {
			System.out.println("该目录不存在！");
		}
	}

	@Test
	public void m3() {
		String directoryPath = "C:\\My_Code\\Java\\stage2\\file\\testDirectory\\a\\z\\x";
		File file = new File(directoryPath);

		if (file.exists()) {
			System.out.println(file.getName() + "存在");
		} else {
			if(file.mkdirs()) {
				System.out.println(directoryPath + "创建成功！");
			} else {
				System.out.println(directoryPath + "创建失败！");
			}
		}
	}
}
