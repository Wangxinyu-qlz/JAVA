package servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java
 * @description: 请求转发
 * TODO 支付界面不要使用转发，一直停留在当前界面，但是对再次请求数据，导致多次支付请求
 * @author: Qiaolezi
 * @create: 2024-02-25 20:36
 **/
@WebServlet({"/s1"})
public class CheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//System.out.println("test");
		//根据用户名确定用户身份
		String username = request.getParameter("username");
		//如果request对象是同一个，那么可以在不同的 Servlet 中使用 getParameter() 方法取出
		if("tom".equals(username)) {// 如果是tom
			//分配权限
			request.setAttribute("role", "管理员");
		} else {//如果不是 tom
			request.setAttribute("role", "普通用户");
		}

		//获取分发器，指定转发的对象：/s2，即Servlet的url
		//"/"：会被解析为 /servlet
		//拼接之后为 /servlet/s2  也就是另一个Servlet的访问地址
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/s2");
		//HTTP Status 404 - /servlet/www.baidu.com
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/www.baidu.com");

		//保证当前的Servlet(s1)的HttpServletRequest HttpServletResponse 对象转发给下一个Servlet(s2)
		requestDispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}