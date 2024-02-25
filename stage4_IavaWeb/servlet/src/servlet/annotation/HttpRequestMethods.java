package servlet.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @description: HttpRequestMrthod
 * @author: Qiaolezi
 * @create: 2024-02-25 18:17
 **/
@WebServlet({"/requestMethods"})
public class HttpRequestMethods extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//使用request对象，获取表单提交的各种数据
		System.out.println("HttpRequestMethods::doPost()被调用");
		System.out.println("请求资源路径： " + request.getRequestURI());
		System.out.println("请求资源绝对路径: " + request.getRequestURL());
		System.out.println("客户端ip: " + request.getRemoteAddr());
		//TODO 如果10秒内某个IP请求次数过多，封IP
		//1.使用集合ConcurrentHashMap保存IP和访问次数
		//2.线程定时扫描
		//3.处理
		System.out.println("http请求头Host: " + request.getHeader("Host"));
		System.out.println("http请求方式： " + request.getMethod());
		String user_Agent = request.getHeader("User-Agent");
		String[] s = user_Agent.split(" ");
		System.out.println("请求的浏览器是： " + s[s.length - 2].split("\\/")[0]);

		//解决参数接收 中文乱码 的问题
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println(username + " " + pwd);
		for (String hobby : hobbies) {
			System.out.println(hobby);
		}

		//本质是在http响应头加上 ContentType: text/html;charset=utf-8
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/x-tar;charset=utf-8");//请求之后会弹出现在界面
		//response.setCharacterEncoding("utf-8");//仍然是乱码
		PrintWriter writer = response.getWriter();
		writer.print("提价的信息为：" + username + " " + pwd);

		writer.flush();
		writer.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
}
