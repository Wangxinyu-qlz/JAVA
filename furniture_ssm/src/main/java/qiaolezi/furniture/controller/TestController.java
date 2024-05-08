package qiaolezi.furniture.controller;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: furnature_ssm
 * @author: Qiaolezi
 * @create: 2024-05-08 12:20
 * @description:
 **/
@Controller
public class TestController {

	@RequestMapping(value = "/hi")
	public String hi() {
		System.out.println("test Controller");
		return "hi";
	}
}
