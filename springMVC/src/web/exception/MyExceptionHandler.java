package web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 21:12
 * @description: TODO 局部异常 > 全局 > SimpleMappingExceptionResolver > tomcat默认机制
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

	@RequestMapping(value = "/testGlobalException")
	public String global() {
		int num = Integer.parseInt("qwe");
		return "success";
	}

	@RequestMapping(value = "/testException02")
	public String test02() {
		//TODO 这样才能显示出自定义的 reason
		// 否则会显示 tomcat 的异常通知界面
		throw new AgeException("年龄必须在1-1501111111之间");
	}

	@RequestMapping(value = "/testException03")
	public String test03() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(arr[1000]);
		return "success";
	}

	@RequestMapping(value = "/testException04")
	public String test04() {
		String str = "hello";
		char c = str.charAt(100);
		return "success";
	}

}
