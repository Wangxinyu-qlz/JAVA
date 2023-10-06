import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Properties02 {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\mysql.properties";
		Properties properties = new Properties();
		properties.load(new FileReader(filePath));
//		读取
		properties.list(System.out);
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		System.out.println("user:" + user + ", password:" + password);

//		创建并修改配置文件内容
//		如果该文件没有该key，就是创建，否则就是修改
		properties.setProperty("charSet", "utf8");
		properties.setProperty("name", "汤姆");//中文保存的是unicode码值
		properties.setProperty("pwd", "123456");
		properties.store(new FileWriter("C:\\My_Code\\Java\\stage2\\file\\mysql.properties"), "test");
		System.out.println("配置文件保存成功！");

	}
}
