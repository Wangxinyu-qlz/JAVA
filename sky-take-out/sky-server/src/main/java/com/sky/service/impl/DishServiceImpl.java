package com.sky.service.impl;

import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-11 16:23
 * @description:
 **/
@Service
@Slf4j
public class DishServiceImpl implements DishService {
	@Autowired
	private DishMapper dishMapper;
	@Autowired
	private DishFlavorMapper dishFlavorMapper;

	/**
	 * 新增菜品和对应的口味
	 * @param dishDTO
	 */
	@Override
	@Transactional //涉及到多个表的操作，要保证原子性
	public void saveWithFlavor(DishDTO dishDTO) {
		Dish dish = new Dish();
		BeanUtils.copyProperties(dishDTO, dish);
		//像菜品表添加一条数据
		dishMapper.insert(dish);
		Long dishId = dish.getId();//mapper useGeneratedKeys="true" keyProperty="id"
		List<DishFlavor> flavors = dishDTO.getFlavors();
		if(flavors != null && !flavors.isEmpty()) {
			//dishId是非必须字段，所以这里需要使用dish的id来设置
			for(DishFlavor flavor : flavors) {
				flavor.setDishId(dishId);
			}
			//向口味表添加n条数据
			dishFlavorMapper.insertBatch(flavors);
		}
	}
}
