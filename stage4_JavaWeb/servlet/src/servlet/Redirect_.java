package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java
 * @description: 重定向返回302状态码
 * @author: Qiaolezi
 * @create: 2024-02-25 16:09
 **/
@WebServlet({"/302"})
public class Redirect_ extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//重定向到login.html   注意加/servlet
		response.sendRedirect("/servlet/login.html");
		//response.sendRedirect("http://www.baidu.com");
		/*
			HTTP/1.1 302 Found
			Server: Apache-Coyote/1.1
			Location: http://www.baidu.com
			Content-Length: 0
			Date: Sun, 25 Feb 2024 08:13:53 GMT
		* */
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//合并doGet和doPost
		doPost(request, response);
	}
}
