import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author qiaolezi
 * @version 1.0
 * 将FileOutputStream字节流 转换为字符流 OutputStreamWriter
 * 指定编码方式
 */
public class OutputStreamWriter_ {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\test_encoder.txt";
		String charSet = "utf8";
		OutputStreamWriter gbk = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
		gbk.write("你好！lenore");

		gbk.close();
		System.out.println("按照" + charSet + "编码保存文件");
	}
}
