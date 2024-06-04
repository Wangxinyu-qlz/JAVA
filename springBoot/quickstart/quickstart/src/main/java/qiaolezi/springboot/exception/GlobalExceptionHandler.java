package qiaolezi.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 15:09
 * @description: @ControllerAdvice + @ExceptionHandler处理全局异常
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
	public String handleException(Exception e, Model model) {
		log.error("异常:{}", e);
		model.addAttribute("message", e.getMessage());
		return "/error/global";//视图地址
	}
}
