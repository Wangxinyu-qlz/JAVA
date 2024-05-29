package qiaolezi.furniture.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import qiaolezi.furniture.bean.Furn;
import qiaolezi.furniture.bean.Message;
import qiaolezi.furniture.service.FurnService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-28 16:15
 * @description:
 **/
//@Controller
@RestController
public class FurnController {
	@Resource
	private FurnService furnService;

	//将前端发送的json数据，转换为JavaBean数据
	@PostMapping("/save")
	//@ResponseBody
	public Message save(@Validated @RequestBody Furn furn, Errors errors) {
		Map<String, Object> map = new HashMap<>();
		List<FieldError> fieldErrors = errors.getFieldErrors();
		for (FieldError e : fieldErrors) {
			map.put(e.getField(), e.getDefaultMessage());
		}

		if (map.isEmpty()) {
			furnService.save(furn);
			return Message.success();
		} else {
			return Message.fail().add("errorMsg", map);

		}
	}

	@RequestMapping("/furns")
	public Message listFurns(){
		List<Furn> furnList = furnService.findAll();
		return Message.success().add("furnList", furnList);
	}

	@DeleteMapping("del/{id}")
	public Message del(@PathVariable int id){
		furnService.delete(id);
		return Message.success();
	}

	@PutMapping("/update")
	public Message update(@RequestBody Furn furn){
		furnService.update(furn);
		return Message.success();
	}

	@GetMapping("/find/{id}")
	public Message listFurns(@PathVariable Integer id){
		Furn furn = furnService.findById(id);
		return Message.success().add("furn", furn);
	}

	//分页查询
	@RequestMapping("/furnByPages")
	public Message listFurnsByPages(@RequestParam(defaultValue = "1") Integer pageNum,
	                                @RequestParam(defaultValue = "5") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		//查询数据，底层进行物理分页，而不是逻辑分页
		//根据分页参数计算limit ?, ?，发出SQL语句时，带上limit
		List<Furn> furnList = furnService.findAll();
		PageInfo pageInfo = new PageInfo(furnList, pageSize);
		return Message.success().add("pageInfo", pageInfo);
	}

	//对数据进行分页查询
	@RequestMapping("/furnByConditionPages")
	public Message listFurnsByConditionPages(@RequestParam(defaultValue = "1") Integer pageNum,
	                                         @RequestParam(defaultValue = "5") Integer pageSize,
	                                         @RequestParam(defaultValue = "") String search) {
		PageHelper.startPage(pageNum, pageSize);
		//查询数据，底层进行物理分页，而不是逻辑分页
		//根据分页参数计算limit ?, ?，发出SQL语句时，带上limit
		List<Furn> furnList = furnService.findByCondition(search);
		PageInfo pageInfo = new PageInfo(furnList, pageSize);
		return Message.success().add("pageInfo", pageInfo);
	}
}
