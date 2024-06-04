package qiaolezi.springboot.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 16:04
 * @description:
 * TODO 不会被SpringBoot拦截器拦截
 *  请求 Servlet 时，不会到达 DispatcherServlet, 因此也不会达到拦截器
 *  原因：注入的Servlet 会存在Spring 容器
 *       DispatherServlet 也存在Spring 容器
 *       两个Servlet在同一个容器（SingletonObjects）中，是同级别的
 *  Tomcat 在对Servlet url 匹配的原则, 多个servlet 都能处理到同一层路径,
 *      精确优先原则/最长前缀匹配原则.（精确路径 > 目录路径 > 扩展名路径 > /* > /）
 **/
@Component
@WebServlet(urlPatterns = {"/servlet01", "/servlet02"})
public class Servlet_ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().print("hello,world");
	}
}
