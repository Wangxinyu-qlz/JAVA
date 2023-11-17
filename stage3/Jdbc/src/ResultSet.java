import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ResultSet {
	public static void main(String[] args) throws Exception {
		//通过Properties对象获取配置文件的信息
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
		Statement statement = connection.createStatement();
		//sql语句
		String sql = "select * from student";
		//
		java.sql.ResultSet resultSet = statement.executeQuery(sql);
		//使用while取出结果
		while(resultSet.next()) {//让光标向后移动，如果没有更多的记录，返回false
			int id = resultSet.getInt(1);//获取该行的第1列
			String name = resultSet.getString(2);//获取该行第2列
			float chinese = resultSet.getFloat(3);
			float english = resultSet.getFloat(4);
			float math = resultSet.getFloat(5);
			System.out.println(id + "\t" + name + "\t" + chinese + "\t" + english + "\t" + math + "\t");
		}

		//关闭连接
		resultSet.close();
		statement.close();
		connection.close();
	}
}
