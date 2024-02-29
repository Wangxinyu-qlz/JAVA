package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 11:18
 * @description:
 **/
//TODO @WebServlet({"/hi1"})注解不能和web.xml配置的路径一样，否则抛出一堆异常
//	如果配置的路径不一样，两个路径都能用
@WebServlet({"/hi1"})
public class HiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//给 servletContext 对象操作属性
		ServletContext servletContext = req.getServletContext();
		servletContext.setAttribute("name", "xy");
		servletContext.setAttribute("name", "1");
		servletContext.removeAttribute("name");
		System.out.println("===============servletContext处理完毕================");

		//获取Session
		//会不会创建session还取决于当前的session是否还活着
		HttpSession session = req.getSession();
		session.setAttribute("address", "123");
		session.setAttribute("address", "111");
		session.removeAttribute("address");
		System.out.println("===============session处理完毕================");

		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.print("你好");

		writer.flush();
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
