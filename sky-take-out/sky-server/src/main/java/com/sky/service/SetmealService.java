package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

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

	/**
	 * 分页查询套餐
	 * @param setmealPageQueryDTO
	 * @return
	 */
	PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

	/**
	 * 批量删除套餐
	 * @param ids
	 */
	void deleteBatch(List<Long> ids);

	/**
	 * 套餐起售停售
	 * @param status
	 * @param id
	 */
	void startOrStop(Integer status, Long id);
}
