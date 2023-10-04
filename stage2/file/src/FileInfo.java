import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class FileInfo {
	public static void main(String[] args) {

	}

//	获取文件信息
	@Test
	public void info() {
		File file = new File("C:\\My_Code\\Java\\stage2\\file\\test1.txt");
//		调用方法
		System.out.println("文件名称：" + file.getName());//文件名称：test1.txt
		System.out.println("文件的绝对路径：" + file.getAbsolutePath());//文件的绝对路径：C:\My_Code\Java\stage2\file\test1.txt
		System.out.println("文件的父级目录：" + file.getParent());//文件的父级目录：C:\My_Code\Java\stage2\file
		System.out.println("文件的大小（字节）" + file.length());//文件的大小（字节）5  UTF-8编码：英文1字节/字符 中文3字节/字符
		System.out.println("test1.txt 是否存在？" + file.exists());//test1.txt 是否存在？true
		System.out.println("是否是一个文件" + file.isFile());//是否是一个文件true
		System.out.println("是否是一个目录？" + file.isDirectory());//是否是一个目录？false
	}
}
