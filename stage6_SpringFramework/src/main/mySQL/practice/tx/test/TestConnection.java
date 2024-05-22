package main.mySQL.practice.tx.test;

import main.mySQL.practice.tx.dao.TestMonster;
import main.spring.myAnnotation.annotation.Autowired;
import main.spring.myAnnotation.annotation.Component;
import main.spring.bean.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 11:22
 * @description:
 **/
public class TestConnection {
	private ApplicationContext ioc;
	@BeforeEach
	public void init() {
		ioc = new ClassPathXmlApplicationContext("tx_practice.xml");
	}

	@Test
	public void testConnection() throws SQLException {
		TestMonster bean = ioc.getBean(TestMonster.class);
		bean.getConnection();
	}


	@Test
	public void testSelect() throws SQLException {
		TestMonster bean = ioc.getBean(TestMonster.class);
		Monster monster = bean.getMonsterById(200);
		System.out.println(monster);
	}
}
