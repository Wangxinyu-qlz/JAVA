package web.debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 22:12
 * @description:
 **/
@Controller
public class HelloHandler {

	@RequestMapping(value = "/debug/springmvc")
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ok");//对应到 /WEB-INF/pages/ok.jsp
		mav.addObject("name", "Hello Spring MVC");
		return mav;
	}
}
