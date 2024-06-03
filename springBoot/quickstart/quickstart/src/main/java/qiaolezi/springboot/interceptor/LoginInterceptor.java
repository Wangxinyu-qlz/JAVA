package qiaolezi.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 17:02
 * @description:
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 目标方法前被调用
	 *
	 * @param request  current HTTP request
	 * @param response current HTTP response
	 * @param handler  chosen handler to execute, for type and/or instance evaluation
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//查看访问的uri
		String uri = request.getRequestURI();
		log.info("================uri:{}=======================",uri);
		//登录校验
		HttpSession session = request.getSession();
		Object loginAdmin = session.getAttribute("loginAdmin");
		if(loginAdmin!=null){
			return true;
		}
		//拦截
		request.setAttribute("message", "请登录~~~");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       @Nullable ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	                             @Nullable Exception ex) throws Exception {
		log.info("afterCompletion");
	}
}
