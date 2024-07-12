package com.sky.service;

import com.sky.dto.SetmealDTO;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-12 15:07
 * @description: 套餐
 **/
public interface SetmealService {
	/**
	 * 新增套餐
	 * @param setmealDTO
	 */
	void saveWithDish(SetmealDTO setmealDTO);
}
