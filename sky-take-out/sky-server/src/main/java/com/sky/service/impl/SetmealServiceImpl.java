package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.exception.SetmealEnableFailedException;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.sky.constant.MessageConstant.SETMEAL_ENABLE_FAILED;
import static com.sky.constant.MessageConstant.SETMEAL_ON_SALE;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-12 15:08
 * @description:
 **/
@Service
@Slf4j
public class SetmealServiceImpl implements SetmealService {
	@Autowired
	private SetmealMapper setmealMapper;
	@Autowired
	private SetmealDishMapper setmealDishMapper;
	@Autowired
	private DishMapper dishMapper;

	/**
	 * 新增套餐
	 * @param setmealDTO
	 */
	@Override
	@Transactional
	public void saveWithDish(SetmealDTO setmealDTO) {
		Setmeal setmeal = new Setmeal();
		BeanUtils.copyProperties(setmealDTO, setmeal);
		//向套餐表添加一条数据
		setmealMapper.insert(setmeal);
		Long setmealId = setmeal.getId();
		List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
		if(setmealDishes != null && !setmealDishes.isEmpty()) {
			for(SetmealDish setmealDish : setmealDishes) {
				setmealDish.setSetmealId(setmealId);
			}
			setmealDishMapper.insertBatch(setmealDishes);
		}
	}

	@Override
	public PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
		PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
		Page<SetmealVO> page = setmealMapper.pageQuery(setmealPageQueryDTO);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void deleteBatch(List<Long> ids) {
		for(Long id : ids) {
			Setmeal setmeal = setmealMapper.getById(id);
			if(setmeal.getStatus() == StatusConstant.ENABLE) {
				throw new DeletionNotAllowedException(SETMEAL_ON_SALE);
			}
		}
		//删除套餐 和 套餐菜品关系表中的数据
		//sql: delete from ? where id in (?,?,?)
		setmealMapper.deleteBatch(ids);
		setmealDishMapper.deleteBatchBySetmealId(ids);
	}

	@Override
	public void startOrStop(Integer status, Long id) {
		if (StatusConstant.ENABLE.equals(status)) {//启用套餐，需要判断套餐内菜品的情况
			//查询该套餐所有菜品的状态
			List<Dish> dishes = dishMapper.getDishesBySetmealDishId(id);
			for (Dish dish : dishes) {
				if (Objects.equals(dish.getStatus(), StatusConstant.DISABLE)) {//套餐关联的菜品状态为停售，则套餐启用失败
					throw new SetmealEnableFailedException(SETMEAL_ENABLE_FAILED);
				}
			}
		}
		Setmeal setmeal = Setmeal.builder()
				.id(id)
				.status(status)
				.build();
		setmealMapper.update(setmeal);
	}
}
