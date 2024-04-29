package web.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 21:37
 * @description:
 **/
@ControllerAdvice
public class MyGlobalException {
	//全局异常不管哪个Handler出现异常，都可以捕获
	//
	@ExceptionHandler({NumberFormatException.class, ClassCastException.class, AgeException.class})
	@RequestMapping(value = "/")
	public String globalException(Exception e, HttpServletRequest request) {
		System.out.println("全局异常处理：" + e.getMessage());
		request.setAttribute("reason", e.getMessage());
		return "exception_mes";
	}
}
