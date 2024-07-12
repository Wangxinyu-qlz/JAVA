package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

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

	/**
	 * 分页查询菜品
	 * @param dishPageQueryDTO
	 * @return
	 */
	PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

	/**
	 * 批量删除菜品
	 * @param ids
	 */
	void deleteBatch(List<Long> ids);

	/**
	 * 根据id查询菜品和对应的口味数据
	 * @param id
	 * @return
	 */
	DishVO getByIdWithFlavor(Long id);

	/**
	 * 根据修改菜品和对应的口味数据
	 * @param dishDTO
	 */
	void updateWithFlavor(DishDTO dishDTO);

	/**
	 * 根据分类id查询菜品
	 * @param categoryId
	 * @return
	 */
	List<Dish> list(Integer categoryId);
}
