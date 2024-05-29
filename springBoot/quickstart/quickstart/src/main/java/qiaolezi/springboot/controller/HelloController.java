package qiaolezi.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
