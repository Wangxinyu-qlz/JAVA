package servlet.servletContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Java
 * @description: GET请求返回数据
 * @author: Qiaolezi
 * @create: 2024-02-25 14:37
 **/
@WebServlet({"/computerServlet"})
public class ComputerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 通过 response 获取流 PrintWriter，给浏览器回复数据
		//2. 为了让浏览器显示中文，显式设置编码为 "utf-8"
		//给回送数据设置编码方式，text/html这个是MIME类型，即告诉浏览器，返回的数据是text类型下的html类型
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//如果不设置编码格式，无法识别 "加减乘除"
		PrintWriter writer = response.getWriter();
		Integer first = Integer.parseInt(request.getParameter("first"));
		Integer second = Integer.parseInt(request.getParameter("second"));
		String[] computers = request.getParameterValues("computer");
		//TODO 这里不能用computer.length == 0判断
		if(computers == null) {//没选
			writer.print("请选一个运算类型！");
		} else if (computers.length > 1) {//选了多个
			writer.print("只能选一个！");
		} else {//选了一个
			if("加".equals(computers[0])) {
				writer.print(first + " + " + second + " = " + (first+second));
			} else if ("减".equals(computers[0])) {
				writer.print(first + " - " + second + " = " + (first-second));
			}else if ("乘".equals(computers[0])) {
				writer.print(first + " x " + second + " = " + (first*second));
			}else if ("除".equals(computers[0])) {
				if (second != 0) {
					writer.print(first + " / " + second + " = " + (first/second));
				} else {
					writer.print("被除数不能等于0！");
				}
			}
		}

		//确保数据返回
		//flush() 方法表示将缓存的数据进行刷新
		writer.flush();
		//close() 方法表示关闭流，及时释放资源
		writer.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//System.out.println("GET方法被调用");
		////1. 通过 response 获取流 PrintWriter，给浏览器回复数据
		////2. 为了让浏览器显示中文，显式设置编码为 "utf-8"
		////给回送数据设置编码方式，text/html这个是MIME类型，即告诉浏览器，返回的数据是text类型下的html类型
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter writer = response.getWriter();
		//writer.print("<h1>登陆成功！</h1>");
		//
		////确保数据返回
		////flush() 方法表示将缓存的数据进行刷新
		//writer.flush();
		////close() 方法表示关闭流，及时释放资源
		//writer.close();
		doPost(request, response);
	}
}
