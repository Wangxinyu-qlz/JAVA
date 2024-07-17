package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 17:12
 * @description:
 **/
@Mapper
public interface ShoppingCartMapper {

	/**
	 * 动态条件查询购物车数据
	 * @return
	 */
	List<ShoppingCart> list(ShoppingCart shoppingCart);

	/**
	 * 根据id修改商品数量
	 * @param cart
	 */
	@Update("update shopping_cart set number = #{number} where id = #{id}")
	void updateNumberById(ShoppingCart cart);

	/**
	 * 插入购物车数据
	 * @param shoppingCart
	 */
	@Insert("insert into shopping_cart (name, user_id, dish_id, setmeal_id, dish_flavor, number, amount, image, create_time)" +
			"values (#{name}, #{userId}, #{dishId}, #{setmealId}, #{dishFlavor}, #{number}, #{amount}, #{image}, #{createTime})")
	void insert(ShoppingCart shoppingCart);

	/**
	 * 动态条件删除
	 * @param cart
	 */
	void delete(ShoppingCart cart);
}
