package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 15:14
 * @description:
 **/
@Controller
public class IndexController {
	@GetMapping(value = {"/", "/login"})
	public String login() {
		//因为引入了starter-thymeleaf
		//这里会使用视图解析到 thymeleaf下的模板文件adminLogin.html
		return "adminLogin";
	}
}
