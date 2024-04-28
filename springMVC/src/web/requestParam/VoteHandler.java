package web.requestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.requestParam.entity.Master;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
		//SpringMVC 自动将 master 放入到 request 中，request域("master", master) 类名首字母小写
		//也可以自己手动放入
		request.setAttribute("master", master);
		request.setAttribute("address", "西安");
		//可以修改master的属性值
		master.setName("qiaolezi");
		System.out.println("ok");
		return "vote_ok";
	}

	@RequestMapping(value = "/vote06")
	public String vote06(Map<String, Object> map, Master master) {
		//SpringMVC 遍历map，将map的K-V放入到request对象
		//
		map.put("master", master);
		map.put("address", "xian");
		map.replace("address", "西安");

		return "vote_ok";
	}

	//Model and View
	@RequestMapping(value = "/vote07")
	public ModelAndView vote07(Master master) {
		System.out.println("===============ModelAndView============");
		ModelAndView modelAndView = new ModelAndView();
		//数据库查询->对象->放入ModelAndView
		modelAndView.addObject("master", master);
		modelAndView.addObject("address", "陕西");
		//指定跳转的视图名称
		modelAndView.setViewName("vote_ok");
		System.out.println("ok");

		//返回结果
		return modelAndView;
	}


	@RequestMapping(value = "/vote08")
	public String vote08(Master master, HttpSession httpSession) {
		//TODO master对象默认是放在request域中的，这里没有显式放，前端也会显示
		httpSession.setAttribute("master", master);
		httpSession.setAttribute("address", "陕西省西安市");
		return "vote_ok";
	}

	/**
	 * 1.当Handler的方法被标识为 @ModelAttribute 该就会被视为一个前置方法
	 * 2.当执行该Handler的其他方法时，会先执行该前置方法
	 * 3.类似于AOP的前置通知
	 *
	 * TODO 用法：修改用户信息
	 *  1.修改前，在前置方法中从数据库查询该用户的信息
	 *  2.在修改方法中，使用前置方法从数据库查询用户信息
	 *  3.如果表单中修了某个属性，以新的数据为准，没有修改，以数据库的信息为准
	 */
	@ModelAttribute
	public void prepareModel() {
		System.out.println("prepareModel()======准备完毕=======");
	}
}
