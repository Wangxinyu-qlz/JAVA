package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 23:25
 * @description:
 **/

public class JDBCUtilsByDruid {

    private static DataSource ds;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
    }

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            //JavaSE方式启动
            //properties.load(new FileInputStream("src\\druid.properties"));
            //1.目前我们是javaWeb方式启动，真正的路径是out/target里面
            //2. 所以要获取src目录下的文件，需要使用类加载器
            properties.load(JDBCUtilsByDruid.class.getClassLoader()
                    .getResourceAsStream("sql.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接：在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
