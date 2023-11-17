import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

/**
 * @author qiaolezi
 * @version 1.0
 * 数据库的 链接 关闭 的工具库
 */
public class JDBCUtils {
	//定义相关的属性，使用static，因为只需要一份
	private static String user;
	private static String password;
	private static String url;
	private static String driver;

	//在static代码块初始化
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("C:\\My_Code\\Java\\stage3\\Jdbc\\src\\mysql.properties"));
			//读取属性
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
		} catch (IOException e) {
			//在实际开发中，可以这样处理
			//编译异常转换为运行异常
			//调用者可以选择 捕获 或者 默认处理，比较方便
			throw new RuntimeException(e);
		}
	}

	//编写方法链接数据库，返回connection
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//关闭数据库
	/*
	* 1.ResultSet
	* 2.Statement / PreparedStatement
	* 3.Connection
	* 如果需要关闭资源，就传入对象，否则传入null*/
	public static void close(ResultSet set, Statement statement, Connection connection) {
		//判断是否为空
		try {
			if(set != null) {
				set.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
