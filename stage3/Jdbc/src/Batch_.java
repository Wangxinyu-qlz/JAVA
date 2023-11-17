import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Batch_ {
	public static void main(String[] args) throws Exception {
		testWithBatch();
	}
	@Test
	public static void testNoBatch() throws Exception {
		Connection connection = JDBCUtils.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("insert into admin1 values(?, ?)");

		long start = System.currentTimeMillis();

		for (int i = 0; i < 5000; i++) {
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, "john"+i);
			preparedStatement.executeUpdate();
		}

		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end-start));//4529
		JDBCUtils.close(null, preparedStatement, connection);
	}

	@Test
	public static void testWithBatch() throws Exception {
		Connection connection = JDBCUtils.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("insert into admin2 values(?, ?)");

		long start = System.currentTimeMillis();

		for (int i = 0; i < 5000; i++) {
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, "john"+i);
			//将sql语句加入到批处理包
			preparedStatement.addBatch();
			if((i+1) % 1000 == 0) {//满1000条
				preparedStatement.executeBatch();//批量执行
				preparedStatement.clearBatch();//清空这一批数据
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end-start));//75
		JDBCUtils.close(null, preparedStatement, connection);
	}
}
