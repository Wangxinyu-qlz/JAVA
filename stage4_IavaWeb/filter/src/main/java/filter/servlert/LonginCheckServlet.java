package filter.servlert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 12:16
 * @description:
 **/
public class LonginCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户名和密码
		//密码是123456就能通过
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if("123456".equals(password)) {
			//合法，将用户名加入 session
			//在这里控制用户多久需要重新登录
			req.getSession().setMaxInactiveInterval(3);
			req.getSession().setAttribute("username", username);

			//合法，请求转发给admin.jsp  这里不会走过滤器，因为是请求转发
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/manage/admin.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			//不合法，返回登陆界面
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
