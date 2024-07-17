package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 16:04
 * @description:
 **/
@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品相关接口")
public class DishController {
	@Autowired
	private DishService dishService;
	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping("/list")
	@ApiOperation("获取菜品列表")
	public Result<List<DishVO>> list(Long categoryId) {
		//构造redis中的key
		String key = "dish_" + categoryId;
		//查询redis中是否有菜品数据
		List<DishVO> list = (List<DishVO>)redisTemplate.opsForValue().get(key);
		if(list != null && list.size()>0) {
			//如果存在直接返回
			return Result.success(list);
		}

		//如果不存在，查询数据库
		Dish dish = new Dish();
		dish.setCategoryId(categoryId);
		dish.setStatus(StatusConstant.ENABLE);
		list = dishService.listWithFlavor(dish);
		//将查到的数据存储在redis中
		redisTemplate.opsForValue().set(key, list);

		return Result.success(list);
	}
}
