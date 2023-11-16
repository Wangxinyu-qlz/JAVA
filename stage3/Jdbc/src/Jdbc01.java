import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 * 演示简单jdbc的操作
 */
public class Jdbc01 {
	public static void main(String[] args) throws SQLException {
		//0.在项目下创建文件夹，
		//1.注册驱动
		Driver driver = new Driver();

		//2.得到连接
				//jdbc:mysql://  表示协议
				//localhost  主机
				//3306  端口
				//db02  数据库名
		String url = "jdbc:mysql://localhost:3306/db02";
			//将用户名密码放入到Properties对象
		Properties properties = new Properties();
			//user password的键是规定好的
		properties.setProperty("user", "root");//用户名
		properties.setProperty("password", "root");//密码
		Connection connect = driver.connect(url, properties);

		//3.执行sql
		String sql = "insert into exam values(9, 99)";
			//statement 执行静态SQL语句并返回生成的结果的对象
		Statement statement = connect.createStatement();
		long rows = statement.executeLargeUpdate(sql);//如果是dml，返回受影响的行数
		System.out.println(rows>0 ? "成功" : "失败");

		//4.关闭连接
		statement.close();
		connect.close();
	}
}
