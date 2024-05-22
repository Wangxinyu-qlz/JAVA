package main.mySQL.practice.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 11:41
 * @description:
 **/
@Repository
public class GoodsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Float selectById(Integer id) {
		String sql = "select price from goods where goods_id = ?";
		Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
		return price;
	}

	public void updateBalance(Integer user_id, Float money) {
		String sql = "update user_account set money = money - ? where user_id = ?";
		jdbcTemplate.update(sql, money, user_id);
	}

	public void updateAmount(Integer goods_id, int amount) {
		String sql = "update goods_amount set goods_num = goods_num - ? where goods_id = ?";
		jdbcTemplate.update(sql, amount, goods_id);
	}
}
