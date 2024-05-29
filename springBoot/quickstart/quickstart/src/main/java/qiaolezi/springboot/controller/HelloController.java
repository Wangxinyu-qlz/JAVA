package qiaolezi.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qiaolezi.springboot.bean.Furn;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 15:21
 * @description:
 **/
@RestController
public class HelloController {

	@RequestMapping("/hello")
	//@ResponseBody//这里不加上访问不到
	public String hello() {
		return "Hello,SpringBoot~";
	}

	@Autowired
	Furn furn;

	@RequestMapping("/furn")
	public Furn furn() {
		return furn;
	}
}
