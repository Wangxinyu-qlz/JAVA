package servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @description: 统计网站被访问次数
 * @author: Qiaolezi
 * @create: 2024-02-25 17:26
 **/
@WebServlet({"/pay"})
public class PayServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletContext servletContext = getServletContext();

		//确认不同的 servlet 共享同一个 servletContext
		//PayServlet 和 OrderServlet 的servletContext的 HashCode 一致
		//PayServlet servletContext= org.apache.catalina.core.ApplicationContextFacade@7e6c83d2
		//运行类型=class org.apache.catalina.core.ApplicationContextFacade
		System.out.println("PayServlet servletContext= " + servletContext +
				"运行类型=" + servletContext.getClass());
		Integer visitCount = WebCount.visitCount(servletContext);

		//输出显示
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>网站的访问次数是" + visitCount + "</h1>");

		writer.flush();
		writer.close();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}

}
