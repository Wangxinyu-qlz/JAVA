package web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 17:34
 * @description:
 **/
@Component  //注入到容器中
public class MyInterceptor01 implements HandlerInterceptor {
	/**
	 * 在目标方法之前执行
	 * 如果preHandle()方法返回false，目标方法不再执行
	 * 根据业务进行拦截 并指定跳转到哪个页面
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler chosen handler to execute, for type and/or instance evaluation
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("第一个拦截器被执行 preHandle");
		String keyword = request.getParameter("keyword");
		if("病毒".equals(keyword)) {
			//请求转发到warnings.jsp
			request.getRequestDispatcher("/WEB-INF/pages/warning.jsp").
					forward(request, response);

			return false;
		}
		System.out.println("抓取到的keyword=" + keyword);
		return true;
	}

	/**
	 * 在目标方法之后执行
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param modelAndView the {@code ModelAndView} that the handler returned
	 * (can also be {@code null})
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("第一个拦截器被执行 postHandler");
	}

	/**
	 * 在视图渲染后执行
	 * 执行资源清理工作
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param ex any exception thrown on handler execution, if any; this does not
	 * include exceptions that have been handled through an exception resolver
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("第一个拦截器被执行 afterCompletion");
	}
}
