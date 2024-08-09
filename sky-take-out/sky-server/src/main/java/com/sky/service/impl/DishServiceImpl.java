package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.entity.Setmeal;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
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
	@Qualifier(value = "dishMapper")
	private DishMapper dishMapper;
	@Autowired
	private DishFlavorMapper dishFlavorMapper;
	@Autowired
	private SetmealDishMapper setmealDishMapper;
	@Autowired
	private SetmealMapper setmealMapper;

	/**
	 * 新增菜品和对应的口味
	 * @param dishDTO
	 */
	@Override
	@Transactional //涉及到多个表的操作，要保证原子性
	public void saveWithFlavor(DishDTO dishDTO) {
		Dish dish = new Dish();
		BeanUtils.copyProperties(dishDTO, dish);
		//向菜品表添加一条数据
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

	/**
	 * 分页查询菜品
	 * @param dishPageQueryDTO
	 * @return
	 */
	@Override
	public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
		PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
		Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 批量删除菜品
	 * @param ids
	 */
	@Override
	@Transactional //多表操作启用事务管理
	public void deleteBatch(List<Long> ids) {
		//判断当前菜品是否能删除？--启售中
		for(Long id : ids) {
			Dish dish = dishMapper.getById(id);
			if(dish.getStatus() == StatusConstant.ENABLE) {
				//当前菜品不能删除
				throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
			}
		}
		//判断当前菜品是否能删除？--是否与套餐关联
		List<Long> setMealIds = setmealDishMapper.getSetMealIdsByDishIds(ids);
		if(setMealIds != null && !setMealIds.isEmpty()) {
			throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
		}

		//删除菜品数据
		//for (Long id : ids) {
		//	dishMapper.deleteById(id);
		//	//删除当前菜品关联的口味数据 不查询直接尝试删除
		//	dishFlavorMapper.deleteByDishId(id);
		//}
		//批量删除菜品数据
		//sql:delete from ? where id in (?,?)
		dishMapper.deleteBatchById(ids);
		dishFlavorMapper.deleteBatchByDishId(ids);

	}

	/**
	 * 根据id查询菜品和对应的口味数据
	 *
	 * @param id
	 * @return
	 */
	@Override
	public DishVO getByIdWithFlavor(Long id) {
		//根据id查询菜品数据
		Dish dish = dishMapper.getById(id);
		//根据菜品id查询口味数据
		List<DishFlavor> flavors = dishFlavorMapper.getByDishId(id);
		//封装到DishVO
		DishVO dishVO = new DishVO();
		BeanUtils.copyProperties(dish, dishVO);
		dishVO.setFlavors(flavors);
		return dishVO;
	}

	/**
	 * 根据id修改菜品和对应的口味信息
	 * @param dishDTO
	 */
	@Override
	public void updateWithFlavor(DishDTO dishDTO) {
		Dish dish = new Dish();
		BeanUtils.copyProperties(dishDTO, dish);
		//修改菜品表基本信息
		dishMapper.update(dish);
		//当前菜品关联的口味数据全部删除，再插入新的口味数据
		dishFlavorMapper.deleteByDishId(dishDTO.getId());
		List<DishFlavor> flavors = dishDTO.getFlavors();
		if(flavors != null && !flavors.isEmpty()) {
			flavors.forEach(dishFlavor -> {
				dishFlavor.setDishId(dishDTO.getId());
			});
			dishFlavorMapper.insertBatch(flavors);
		}
	}

	/**
	 * 根据分类id查询菜品
	 *
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<Dish> list(Long categoryId) {
		Dish dish = Dish.builder()
				.categoryId(categoryId)
				.status(StatusConstant.ENABLE)
				.build();
		return dishMapper.list(dish);
	}

	/**
	 * 启用停用菜品，停用菜品时需要将包含其的套餐停用
	 *
	 * @param status
	 * @param id
	 */
	@Override
	public void startOrStop(Integer status, Long id) {
		Dish dish = Dish.builder()
				.status(status)
				.id(id)
				.build();
		dishMapper.update(dish);
		if (status == StatusConstant.DISABLE) {
			//将包含其的套餐停用
			List<Long> setMealIds = setmealDishMapper.getSetMealIdsByDishIds(Collections.singletonList(id));
			if (setMealIds != null && !setMealIds.isEmpty()) {
				for (Long setMealId : setMealIds) {
					Setmeal setmeal = Setmeal.builder()
							.status(status)
							.id(setMealId)
							.build();
					setmealMapper.update(setmeal);
				}
			}
		}
	}

	@Override
	public List<DishVO> listWithFlavor(Dish dish) {
		List<Dish> dishList = dishMapper.list(dish);

		ArrayList<DishVO> dishVOList = new ArrayList<>();

		for(Dish d : dishList) {
			DishVO dishVO = new DishVO();
			BeanUtils.copyProperties(d, dishVO);

			//根据菜品id查询对应的口味
			List<DishFlavor> flavors = dishFlavorMapper.getByDishId(d.getId());
			dishVO.setFlavors(flavors);
			dishVOList.add(dishVO);
		}

		return dishVOList;
	}
}
