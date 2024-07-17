package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCartMapper;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 17:08
 * @description:
 **/
@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private DishMapper dishMapper;
	@Autowired
	private SetmealMapper setmealMapper;

	/**
	 * 添加购物车
	 *
	 * @param shoppingCartDTO
	 */
	@Override
	public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = new ShoppingCart();
		BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
		shoppingCart.setUserId(BaseContext.getCurrentId());
		//判断商品是否已经存在于购物车
		//实际这里只会查到一条，因为是根据setmealId / dishId查询，只会一个符合条件
		List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
		//如果商品已经存在，数量+1
		if (list != null && !list.isEmpty()) {
			ShoppingCart cart = list.get(0);
			cart.setNumber(cart.getNumber() + 1);
			//update shopping_cart set number = ? where id = ?
			shoppingCartMapper.updateNumberById(cart);
		} else {//如果不存在，加入
			//判断本次添加到购物车的是菜品还是套餐
			Long dishId = shoppingCartDTO.getDishId();
			if (dishId != null) {//本次添加到购物车的是菜品
				//查询菜品
				Dish dish = dishMapper.getById(dishId);
				shoppingCart.setName(dish.getName());
				shoppingCart.setImage(dish.getImage());
				shoppingCart.setAmount(dish.getPrice());
			} else {//本次添加到购物车的是套餐
				Long setmealId = shoppingCartDTO.getSetmealId();
				Setmeal setmeal = setmealMapper.getById(setmealId);
				shoppingCart.setName(setmeal.getName());
				shoppingCart.setImage(setmeal.getImage());
				shoppingCart.setAmount(setmeal.getPrice());
			}
			shoppingCart.setNumber(1);
			shoppingCart.setCreateTime(LocalDateTime.now());
			shoppingCartMapper.insert(shoppingCart);
		}


	}

	@Override
	public List<ShoppingCart> showShoppingCart() {
		Long currentId = BaseContext.getCurrentId();
		ShoppingCart shoppingCart = ShoppingCart.builder()
				.id(currentId)
				.build();

		List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);

		return list;
	}

	@Override
	public void subShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = new ShoppingCart();
		BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
		shoppingCart.setUserId(BaseContext.getCurrentId());
		List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);//只会查到一条
		if(list!=null && !list.isEmpty()) {
			ShoppingCart cart = list.get(0);
			Integer number = cart.getNumber();
			//判断数量，如果>1：-1 如果==1:delete
			if(number > 1) {
				cart.setNumber(number - 1);
				shoppingCartMapper.updateNumberById(cart);
			} else {
				//根据dishId或者setmealId删除这个商品
				shoppingCartMapper.delete(cart);
			}
		}
	}
}
