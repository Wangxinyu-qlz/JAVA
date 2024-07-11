package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-11 16:33
 * @description:
 **/
@Mapper
public interface DishFlavorMapper {
	void insertBatch();
}
