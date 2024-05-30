package qiaolezi.springboot.controller;

import org.springframework.web.bind.annotation.*;
import qiaolezi.springboot.bean.Monster2;

import javax.annotation.Resource;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:58
 * @description:
 **/
@RestController
public class MonsterController {
	@Resource
	private Monster2 monster2;
	@RequestMapping("/monster2")
	public Monster2 monster() {
		return monster2;
	}

	//TODO 相同的路由可以，请求的方式不同
	// 客户端是PostMan，可以直接发送put delete get post请求，可以不设置Filter
	// 但是通过表单提交，需要开启HiddenHttpMethodFilter 在application.yaml中配置
	@GetMapping("/monster")
	public String getMonster() {
		return "GET-查询";
	}

	@PostMapping("/monster")
	public String saveMonster() {
		return "POST-保存";
	}

	@PutMapping("/monster")
	public String putMonster() {
		return "PUT-修改";
	}

	@DeleteMapping("/monster")
	public String deleteMonster() {
		return "DELETE-删除";
	}
}
