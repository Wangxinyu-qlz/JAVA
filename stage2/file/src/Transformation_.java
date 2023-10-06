import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Transformation_ {
	public static void main(String[] args) throws IOException{

	}

	@Test
	public void m1() throws IOException {//乱码问题
//		读取C:\My_Code\Java\stage2\file\story.txt 到程序
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story_gbk.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		默认读取的编码格式为 UTF-8，如果文件的编码格式为国标等等，会出现乱码
		String s = bufferedReader.readLine();
		System.out.println(s);
		bufferedReader.close();
	}

	@Test
//	将字节流 FileInputStream 转换为 字符流InputStreamReader，指定编码 gbk/UTF-8
	public void m2() throws IOException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\story_gbk.txt";
//		1.将FileInputStream转换为InputStreamReader
//		2.指定编码
//		InputStreamReader gbk = new InputStreamReader(new FileInputStream(filePath), "gbk");
//		3.把InputStreamReader 传入 BufferedReader
//		BufferedReader bufferedReader = new BufferedReader(gbk);

//		将2和3合并
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filePath), "gbk"));

//		4.读取内容
		String s = bufferedReader.readLine();
		System.out.println(s);
//      5.关闭流
		bufferedReader.close();
	}
}
