package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-12 11:39
 * @description:
 **/
@Mapper
public interface SetmealDishMapper {
	/**
	 * 根据菜品id查询套餐id
	 * @param dishIds
	 * @return
	 */
	public List<Long> getSetMealIdsByDishIds(List<Long> dishIds);

	/**
	 * 批量插入套餐和菜品的关联数据
	 * @param setmealDishes
	 */
	void insertBatch(List<SetmealDish> setmealDishes);
}
