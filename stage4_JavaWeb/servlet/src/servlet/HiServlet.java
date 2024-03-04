package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java
 * @description: 通过继承HttpServlet开发HiServlet
 * @author: Qiaolezi
 * @create: 2024-02-24 13:15
 **/
public class HiServlet extends HttpServlet {
	//重写 HttpServlet 的 doGet 和 doPost 方法

	/**
	 * 处理doPost请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HiServlet:doGet()");
	}

	/**
	 * 处理doPost请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HiServlet:doPost()");
	}
}
