import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 22:25
 * @description:
 **/
@WebServlet({"/servlet"})
public class servlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO 如果浏览器有缓存，刷新后台不会再次输出这句话
		System.out.println("servlet转发===============");
		//TODO 在服务器端，解析第一个"/"会被解析为 "http://ip:port/project_name"
		//"/d1/d2/b.html" == "http://ip:port/project_name/d1/d2/b.html
		request.getRequestDispatcher("/d1/d2/b.html").forward(request, response);
		//没有"/"，浏览器默认按照 "http://ip:port/project_name" + "path" 拼接
		request.getRequestDispatcher("d1/d2/b.html").forward(request, response);

		//有下列语句的时候，转发不成功，什么原因？没有重启，重新部署不起作用，重启才行
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("servlet");

		writer.flush();
		writer.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}
