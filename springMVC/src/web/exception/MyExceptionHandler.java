package web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 21:12
 * @description:
 **/
@Controller
public class MyExceptionHandler {

	@ExceptionHandler({ArithmeticException.class, NullPointerException.class})
	public String localException(Exception exception, HttpServletRequest request) {
		System.out.println("异常信息" + exception.getMessage());
		request.setAttribute("reason", exception.getMessage());

		return "exception_mes";
	}

	@RequestMapping(value = "/testException01")
	public String test01(Integer num) {
		int i = 9 / num;
		return "success";
	}
}
