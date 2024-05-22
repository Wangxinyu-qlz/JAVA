package main.mySQL.practice.tx_practice.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 14:47
 * @description:
 **/
public class TestConnection {
	@Test
	public void testConnection() throws SQLException {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_p.xml");
		DataSource dataSource = ioc.getBean(DataSource.class);
		System.out.println(dataSource);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}
}
