package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qiaolezi.springboot.bean.Monster2;

import javax.annotation.Resource;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:58
 * @description:
 **/
//@RestController
@Controller
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

	//为什么这里 return "GET-查询妖怪",返回的是字符串,而不是转发到对应的资源文件?
	// 因为@ResController是一个复合注解,含有@ResponseBody,所以springboot底层(springmvc), 在处理
	// return "xxx" 时, 会以@ResponseBody 注解进行解析处理, 即返回字符串 "xxx", 而不会使用视图解析器来处理.
	// 如果把 @RestController 改成 @Controller , 访问getMonster() 时, 如果有xxx.html
	// 就会转发到xxx.html , 如果没有xxx.html , 就会报404
	// 提示: 在测试时, 讲xxx.html 放在 main\resources\public\xxx.html 进行测试, 并在application.yml 配置视图解析器
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
