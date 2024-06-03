package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 10:17
 * @description:
 **/
@Controller
public class RequestController {
	@GetMapping("/login1")
	public String login(HttpServletRequest request) {
		request.setAttribute("user", "l");
		return "forward:/ok";
	}

	@ResponseBody
	@GetMapping("/ok")
	public String ok(@RequestAttribute(value = "user", required = false)String user,
	                 HttpServletRequest request) {
		//request域中user = l
		//request域中user = l
		System.out.println("request域中user = " + user);
		System.out.println("request域中user = " + request.getAttribute("user"));
		return "success";
	}

	//	1. 在开发中，SpringBoot 在响应客户端请求时，也支持复杂参数
	//  2. Map、Model、Errors/BindingResult、RedirectAttributes、
	//     ServletResponse、SessionStatus、UriComponentsBuilder、
	//     ServletUriComponentsBuilder、HttpSession
	//  3. Map、Model 数据会被放在request 域， 底层request.setAttribute()
	//  4. RedirectAttributes 重定向携带数据
	@GetMapping("/register")
	public String register(Map<String, Object> map,
	                       Model model,
	                       HttpServletResponse response) {
		map.put("user", "l");
		map.put("job", "i");
		model.addAttribute("sal", 1111111.1);
		Cookie cookie = new Cookie("pwd", "6666");
		response.addCookie(cookie);
		return "forward:/registerOk";
	}

	@ResponseBody
	@GetMapping("/registerOk")
	public String registerOk(HttpServletRequest request){
		//request域中user = l
		//request域中job =i
		//request域中sal =1111111.1
		System.out.println("request域中user = " + request.getAttribute("user"));
		System.out.println("request域中job =" + request.getAttribute("job"));
		System.out.println("request域中sal =" + request.getAttribute("sal"));

		return "success";
	}
}
