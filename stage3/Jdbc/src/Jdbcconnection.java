import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Jdbcconnection {
	//方式1
	@Test
	public void connect01() throws SQLException {
		Driver driver = new Driver();
		String url = "jdbc:mysql://localhost:3306/db02";
		Properties properties = new Properties();
		properties.setProperty("user", "root");//用户名
		properties.setProperty("password", "root");//密码
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);//com.mysql.cj.jdbc.ConnectionImpl@480bdb19
	}

	//使用反射
	@Test
	public void connect02() throws Exception {
		//使用反射加载Driver类，动态加载，减少依赖性
		Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver)aClass.newInstance();
		String url = "jdbc:mysql://localhost:3306/db02";
		Properties properties = new Properties();
		properties.setProperty("user", "root");//用户名
		properties.setProperty("password", "root");//密码

		Connection connect = driver.connect(url, properties);
		System.out.println(connect);//com.mysql.cj.jdbc.ConnectionImpl@480bdb19
	}

	//使用DriverManager 替代 driver 进行统一管理
	@Test
	public void connect03() throws Exception {
		Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver)aClass.newInstance();
		String url = "jdbc:mysql://localhost:3306/db02";
		String user = "root";
		String password = "root";
		DriverManager.registerDriver(driver);//注册driver驱动
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);//com.mysql.cj.jdbc.ConnectionImpl@682b2fa
	}

	//TODO 推荐使用 使用Class.froName 自动完成数据库注册驱动，简化代码
	@Test
	public void connect04() throws Exception{
		//在加载Driver类时，完成注册
		/*
			static {
		        try {
		            DriverManager.registerDriver(new Driver());
		        } catch (SQLException var1) {
		            throw new RuntimeException("Can't register driver!");
		        }
		    }
	    * */
		Class.forName("com.mysql.cj.jdbc.Driver");//V5.1.5以后可以不写 但建议写上
		String url = "jdbc:mysql://localhost:3306/db02";
		String user = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);//com.mysql.cj.jdbc.ConnectionImpl@139982de
	}

	//在方式4的基础上进行改进，增加配置文件，使用软编码，增加灵活性
	@Test
	public void connect05() throws Exception {
		//通过Properties对象获取配置文件的信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\mysql.properties"));
		//获取相关的值
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);//com.mysql.cj.jdbc.ConnectionImpl@139982de
	}
}
