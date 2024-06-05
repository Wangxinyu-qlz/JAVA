package qiaolezi.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import qiaolezi.springboot.bean.Furn;
import qiaolezi.springboot.service.FurnService;
import qiaolezi.springboot.util.Result;

import java.util.HashMap;
import java.util.List;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:50
 * @description:
 **/
@RestController
public class FurnController {
	@Autowired
	private FurnService furnService;

	@PostMapping("/save")
	public Result<?> save(@Validated @RequestBody Furn furn, Errors errors) {
		HashMap<String, Object> map = new HashMap<>();
		List<FieldError> fieldErrors = errors.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		if (map.isEmpty()) {
			furnService.save(furn);
			return Result.success();
		} else {
			return Result.error("400", "校验失败", map);
		}

	}

	@RequestMapping("/furns")
	public Result<?> getFurns() {
		List<Furn> furns = furnService.list();
		return Result.success(furns);
	}

	@PutMapping("/update")
	public Result<?> update(@RequestBody Furn furn) {
		furnService.updateById(furn);
		return Result.success();
	}

	@DeleteMapping("/delete/{id}")
	public Result<?> delete(@PathVariable Integer id) {
		furnService.removeById(id);
		return Result.success();
	}

	@RequestMapping("/furnsByPage")
	public Result<?> listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
	                                 @RequestParam(defaultValue = "5") Integer pageSize) {
		Page<Furn> furnPage = furnService.page(new Page<>(pageNum, pageSize));
		return Result.success(furnPage);
	}

	@RequestMapping("/furnsBySearchPage")
	public Result<?> listFurnsBySearchPage(@RequestParam(defaultValue = "1") Integer pageNum,
	                                       @RequestParam(defaultValue = "5") Integer pageSize,
	                                       @RequestParam(defaultValue = "") String search) {
		QueryWrapper<Furn> queryWrapper = Wrappers.query();
		if (StringUtils.hasText(search)) {
			queryWrapper.like("name", search);
		}
		Page<Furn> furnPage = furnService.page(new Page<>(pageNum, pageSize), queryWrapper);
		return Result.success(furnPage);
	}
}
