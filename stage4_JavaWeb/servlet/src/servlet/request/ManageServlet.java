package servlet.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @description: 请求转发
 * @author: Qiaolezi
 * @create: 2024-02-25 20:36
 **/
@WebServlet({"/s2"})
public class ManageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//System.out.println("test");
		String username = request.getParameter("username");
		String role = (String) request.getAttribute("role");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("用户名:" + username + "<br/>" + "角色:" + role);

		writer.flush();
		writer.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
}
