package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 17:06
 * @description:
 **/
public interface ShoppingCartService {
	/**
	 * 添加购物车
	 * @param shoppingCartDTO
	 */
	void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

	/**
	 * 查看购物车
	 * @return
	 */
	List<ShoppingCart> showShoppingCart();

	/**
	 * 减少购物车商品数量
	 * @param shoppingCartDTO
	 */
	void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
