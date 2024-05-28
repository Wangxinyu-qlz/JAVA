package qiaolezi.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qiaolezi.furniture.bean.Furn;
import qiaolezi.furniture.bean.Message;
import qiaolezi.furniture.service.FurnService;

import javax.annotation.Resource;
import java.util.List;

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
	public Message save(@RequestBody Furn furn){
		furnService.save(furn);
		return Message.success();
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
}
