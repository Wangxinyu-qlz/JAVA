package tomcat.servlet;

import tomcat.http.MyRequest;
import tomcat.http.MyResponse;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 14:55
 * @description:
 **/
public abstract class MyHttpServlet implements MyServlet{
	//dynamic binding
	@Override
	public void service(MyRequest request, MyResponse response) throws IOException {
		if("GET".equalsIgnoreCase(request.getMethod())) {
			//动态绑定
			this.doGet(request, response);
		} else if ("POST".equalsIgnoreCase(request.getMethod())) {
			this.doPost(request, response);
		}
	}

	//TODO 使用抽象模板设计模式
	//让 MyHttpServlet 子类 MyCalculateServlet 实现
	public abstract void doGet(MyRequest request, MyResponse response) throws IOException;
	public abstract void doPost(MyRequest request, MyResponse response) throws IOException;
}
