import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 *  * 有SQL注入风险，通过字符串拼接的方式
 *  * 万能密码：1' or      or '1'= '1
 */
public class Statement {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String admin_name = scanner.nextLine();
		System.out.print("请输入密码：");
		String admin_password = scanner.nextLine();

		//通过properties对象获取配置文件信息
		Properties properties = new Properties();
		properties.load(Files.newInputStream(Paths.get("C:\\My_Code\\Java\\stage3\\Jdbc\\src\\mysql.properties")));
		//获取相关的值
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");

		//注册驱动器
		Class.forName(driver);
		//得到连接
		Connection connection = DriverManager.getConnection(url, user, password);
		//得到statement
		java.sql.Statement statement = connection.createStatement();
		//组织SQL
		String sql = "select name, pwd from admin where name = '" + admin_name + "' and pwd = '" + admin_password + "'";
		ResultSet resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			System.out.println("登陆成功！");
		} else {
			System.out.println("登陆失败");
		}

		//关闭连接
		resultSet.close();
		statement.close();
		connection.close();
	}
}
