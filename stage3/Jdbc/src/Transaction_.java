import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Transaction_ {
	//不适用事务
	@Test
	public void test1() {
		Connection connection = null;
		//张三给李四转账
		String sql1 = "update account set balance = balance - 100 where name = '张三'";
		String sql2 = "update account set balance = balance + 100 where name = '李四'";
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();//TODO 在默认情况下，connection是自动提交的
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();

			int i = 1/0;
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}

	//使用事务解决
	@Test
	public void test2() {
		Connection connection = null;
		//张三给李四转账
		String sql1 = "update account set balance = balance - 100 where name = '张三'";
		String sql2 = "update account set balance = balance + 100 where name = '李四'";
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			//将connection设置为不自动提交
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();

			int i = 1/0;//抛出异常
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();

			//提交事务
			connection.commit();
		} catch (Exception e) {
			//在这里回滚
			System.out.println("执行发生异常，准备撤销");
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}
}
