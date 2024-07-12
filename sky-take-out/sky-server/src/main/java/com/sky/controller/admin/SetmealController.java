package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-12 14:58
 * @description: 套餐管理接口
 **/
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐相关接口")
@Slf4j
public class SetmealController {
	@Autowired
	private SetmealService setmealService;

	@PostMapping
	@ApiOperation("新增套餐")
	public Result save(@RequestBody SetmealDTO setmealDTO) {
		log.info("新增套餐");
		setmealService.saveWithDish(setmealDTO);
		return Result.success();
	}

	@GetMapping("/page")
	@ApiOperation("分页查询")
	public Result pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
		log.info("分页查询套餐：{}", setmealPageQueryDTO);
		PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
		return Result.success(pageResult);
	}

	@DeleteMapping
	@ApiOperation("批量删除套餐")
	public Result delete(@RequestParam List<Long> ids) {
		log.info("批量删除套餐：{}", ids);
		setmealService.deleteBatch(ids);
		return Result.success();
	}

	@PostMapping("/status/{status}")
	@ApiOperation("套餐起售停售")
	public Result startOrStop(@PathVariable Integer status, Long id) {
		setmealService.startOrStop(status, id);
		return Result.success();
	}
}
