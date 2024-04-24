package main.mySQL.dao;

import main.spring.bean.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-24 09:12
 * @description:
 **/
@Repository
public class MonsterDao {
	//注入一个属性
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//保存任务
	public void save(Monster monster) {
		String sql = "INSERT INTO monster VALUES(?,?,?)";
		int affected = jdbcTemplate.update
				(sql, monster.getMonsterId(), monster.getName(), monster.getSkill());

		System.out.println("affected = " + affected);
	}
}
