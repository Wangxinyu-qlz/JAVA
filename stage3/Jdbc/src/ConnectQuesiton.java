import java.sql.Connection;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ConnectQuesiton {
	public static void main(String[] args) {
		testConnection();
	}

	//传统连接比较耗时
	public static void testConnection() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = JDBCUtils.getConnection();//Exception: Too many connections

			//关闭
			JDBCUtils.close(null, null, connection);
		}
		long end = System.currentTimeMillis();//耗时：24059
		System.out.println("耗时："  + (end - start));
	}
}
