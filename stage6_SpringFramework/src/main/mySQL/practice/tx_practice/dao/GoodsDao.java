package main.mySQL.practice.tx_practice.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 14:52
 * @description:
 **/
@Repository
public class GoodsDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public Double queryPriceById(int id) {
		String sql = "select price from goods where goods_id = ?";
		return jdbcTemplate.queryForObject(sql, Double.class, id);
	}

	public void updateGoodsNum(int goods_id, int goods_num) {
		String sql = "update goods_amount set goods_num = goods_num - ? where goods_id = ?";
		jdbcTemplate.update(sql, goods_num, goods_id);
	}

	public void updateUserBalance(int user_id, Double money) {
		String sql = "update user_account set money = money - ? where user_id = ?";
		jdbcTemplate.update(sql, money, user_id);
	}

	public Double queryPriceById1(int id) {
		String sql = "select price from goods where goods_id = ?";
		return jdbcTemplate.queryForObject(sql, Double.class, id);
	}

	public void updateGoodsNum1(int goods_id, int goods_num) {
		String sql = "update goods_amount set goods_num = goods_num - ? where goods_id = ?";
		jdbcTemplate.update(sql, goods_num, goods_id);
	}

	public void updateUserBalance1(int user_id, Double money) {
		String sql = "update user_account set money = money - ? where user_id = ?";
		jdbcTemplate.update(sql, money, user_id);
	}
}
