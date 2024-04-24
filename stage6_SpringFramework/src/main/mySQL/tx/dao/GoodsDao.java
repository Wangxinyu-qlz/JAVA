package main.mySQL.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-24 09:50
 * @description:
 **/
@Repository
public class GoodsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据商品id返回价格
	 *
	 * @param id
	 * @return
	 */
	public Float queryPriceById(Integer id) {
		String sql = "SELECT price FROM goods WHERE goods_id=?";
		Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
		return price;
	}

	/**
	 * 修改用户的余额，主要是减少
	 *
	 * @param user_id
	 * @param money
	 */
	public void updateBalance(Integer user_id, Float money) {
		String sql = "UPDATE user_account SET money=money-? WHERE user_id=?";
		jdbcTemplate.update(sql, money, user_id);
	}

	/**
	 * 修改商品库存，主要是减少
	 *
	 * @param goods_id
	 * @param amount
	 */
	public void updateAmount(Integer goods_id, int amount) {
		String sql = "UPDATE goods_amount SET goods_num=goods_num-? WHERE goods_id=?";
		jdbcTemplate.update(sql, amount, goods_id);
	}


	public Float queryPriceById2(Integer id) {
		String sql = "SELECT price FROM goods WHERE goods_id=?";
		Float price = jdbcTemplate.queryForObject(sql, Float.class, id);
		return price;
	}

	/**
	 * 修改用户的余额，主要是减少
	 *
	 * @param user_id
	 * @param money
	 */
	public void updateBalance2(Integer user_id, Float money) {
		String sql = "UPDATE user_account SET money=money-? WHERE user_id=?";
		jdbcTemplate.update(sql, money, user_id);
	}

	/**
	 * 修改商品库存，主要是减少
	 *
	 * @param goods_id
	 * @param amount
	 */
	public void updateAmount2(Integer goods_id, int amount) {
		String sql = "UPDATE goods_amount SET goods_num=goods_num-? WHERE goods_id=?";
		jdbcTemplate.update(sql, amount, goods_id);
	}
}
