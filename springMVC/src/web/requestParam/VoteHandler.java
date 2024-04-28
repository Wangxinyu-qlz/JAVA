package web.requestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.requestParam.entity.Master;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 12:13
 * @description:
 **/
@RequestMapping(value = "/vote")
@Controller
public class VoteHandler {
	/**
	 * @param username
	 * @return
	 * @RequestParam(value = "name", required = false)
	 * 表示会接收提交的参数
	 * value="name"表示提交的参数名是name
	 * required="false"表示该参数可以没有  （默认是true，必须有）
	 */
	@RequestMapping(value = "/vote01")
	public String vote01(@RequestParam(value = "name", required = false) String username) {
		System.out.println("username=" + username);
		return "success";
	}

	@RequestMapping(value = "/vote02")
	public String vote02(@RequestHeader("Accept-Encoding") String acceptEncoding,
	                     @RequestHeader("Host") String host) {
		System.out.println("acceptEncoding=" + acceptEncoding);
		System.out.println("Host=" + host);
		return "success";
	}

	//获取提交的数据，封装为javabean
	//方法形参使用对象的类型即可，SpringMVC 自动进行封装
	//前提：提交数据：参数名和对象字段名 一致
	//如果属性是对象，通过字段名.字段名 Master[pet]  pet.id pet.name
	//如果匹配失败 -> null
	@RequestMapping(value = "/vote03")
	public String vote03(Master master) {
		System.out.println("master=" + master);
		return "success";
	}

	/**
	 * 使用servlet api获取提交的数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/vote04")
	public String vote04(HttpServletRequest request,
	                     HttpServletResponse response,
	                     HttpSession hs) {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println("username=" + username);
		System.out.println("pwd=" + pwd);

		HttpSession session = request.getSession();
		//session=org.apache.catalina.session.StandardSessionFacade@1c82f80a
		//hs=org.apache.catalina.session.StandardSessionFacade@1c82f80a
		System.out.println("session=" + session);
		System.out.println("hs=" + hs);
		return "success";
	}

	@RequestMapping(value = "/vote05")
	public String vote05(Master master,
	                     HttpServletRequest request,
	                     HttpServletResponse response) {
		//SpringMVC 自动将 master 放入到 request 中，
		//也可以自己手动放入
		request.setAttribute("master", master);
		request.setAttribute("address", "西安");
		System.out.println("ok");
		return "vote_ok";
	}
}
