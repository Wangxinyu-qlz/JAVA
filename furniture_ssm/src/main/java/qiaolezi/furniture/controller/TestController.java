package qiaolezi.furniture.controller;

import org.springframework.stereotype.Controller;

/**
 * @program: furnature_ssm
 * @author: Qiaolezi
 * @create: 2024-05-08 12:20
 * @description:
 **/
@Controller
public class TestController {

	public String hi() {
		System.out.println("test Controller");
		return "hi";
	}
}
