package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-11 16:21
 * @description:
 **/
public interface DishService {
	/**
	 * 新增菜品和对应的口味数据
	 * @param dishDTO
	 */
	public void saveWithFlavor(DishDTO dishDTO);

	PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

	void deleteBatch(List<Long> ids);
}
