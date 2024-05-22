package main.mySQL.practice.tx.dao;

import main.spring.bean.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 11:30
 * @description:
 **/
@Repository
public class TestMonster {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void getConnection() throws SQLException {
		DataSource dataSource = jdbcTemplate.getDataSource();
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

	public Monster getMonsterById(Integer id) {
		String sql = "select id as monsterId, name, skill from monster where id = ?";
		BeanPropertyRowMapper<Monster> monsterBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Monster.class);
		Monster monster = jdbcTemplate.queryForObject(sql, monsterBeanPropertyRowMapper, id);
		return monster;
	}
}
