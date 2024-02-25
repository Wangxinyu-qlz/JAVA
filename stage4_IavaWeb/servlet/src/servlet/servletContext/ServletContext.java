package servlet.servletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Java
 * @description: 演示ServletContext的作用
 * @author: Qiaolezi
 * @create: 2024-02-25 17:10
 **/
@WebServlet({"/servletContext"})
public class ServletContext extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		//获取web.xml的context-parameter
		javax.servlet.ServletContext servletContext = getServletContext();
		String website = servletContext.getInitParameter("website");
		String school = servletContext.getInitParameter("school");
		String contextPath = servletContext.getContextPath();
		//     / 表示我们的项目（发布后）的 根路径
		String realPath = servletContext.getRealPath("/");
		System.out.println("website:" + website + " school:" + school);
		//Path: /servlet
		//RealPath: C:\My_Code\Java\out\artifacts\servlet_Web_exploded\
		System.out.println("Path: " + contextPath + "\nRealPath: " + realPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
}
