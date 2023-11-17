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
 */
public class PreparedStatement {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String admin_name = scanner.nextLine();
		System.out.print("请输入密码:");
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
		//组织SQL
		//查询
		String sql_select = "select name, pwd from admin where name =? and pwd =?";
		//修改
		String sql_update = "update admin set pwd = ? where name = ?";
		//添加
		//String sql_insert = "insert into admin values (?, ?)";
		//删除


		//得到PreparedStatement
		//返回的preparedStatement对象是实现了PreparedStatement接口的实现类的对象
		java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql_update);
		//给 ? 赋值
		preparedStatement.setString(1, admin_name);
		preparedStatement.setString(2, admin_password);
		//TODO 这里不需要填写sql语句参数
		//执行select使用executeQuery()
		//ResultSet resultSet = preparedStatement.executeQuery();
		//执行dml(delete, update, insert)使用executeUpdate()
		int rows = preparedStatement.executeUpdate();

		//if(resultSet.next()) {
		//	System.out.println("登陆成功！");
		//} else {
		//	System.out.println("登陆失败");
		//}
		System.out.println(rows > 0 ? "插入成功！" : "插入失败！");

		//关闭连接
		//resultSet.close();
		preparedStatement.close();
		connection.close();
	}
}
