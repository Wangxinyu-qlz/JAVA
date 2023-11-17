import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class JDBCUtilsUse {
	@Test
	public void test() {
		Connection connection = null;
		String sql = "update admin set pwd = ? where name = ?";
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "qqq");
			preparedStatement.setString(2, "123");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(null, preparedStatement, connection);
		}
	}
}
