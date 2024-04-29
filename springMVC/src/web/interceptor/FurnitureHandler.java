package web.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 17:53
 * @description:
 **/
@Controller
public class FurnitureHandler {
	@RequestMapping(value = "/hi")
	public String hi() {
		System.out.println("FurnitureHandler::hi()");
		return "success";
	}

	@RequestMapping(value = "/hello")
	public String hello() {
		System.out.println("FurnitureHandler::hello()");
		return "success";
	}

	@RequestMapping(value = "/ok")
	public String ok() {
		System.out.println("FurnitureHandler::ok()");
		return "success";
	}
}
