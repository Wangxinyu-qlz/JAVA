package qiaolezi.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 17:02
 * @description:
 **/
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		return false;
	}
}
