package tomcat.servlet;

import tomcat.http.MyRequest;
import tomcat.http.MyResponse;
import utils.WebUtils;

import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 14:56
 * @description:
 **/
public class MyCalculateServlet extends MyHttpServlet {

	@Override
	public void doGet(MyRequest request, MyResponse response) throws IOException {
		int num1 = WebUtils.parerInt(request.getParameter("num1"), 0);
		int num2 = WebUtils.parerInt(request.getParameter("num2"), 0);
		OutputStream outputStream = response.getOutputStream();
		String responseMes = MyResponse.responseHeader + (num1+num2) + "加法反射构建";
		outputStream.write(responseMes.getBytes());

		outputStream.flush();
		outputStream.close();
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) throws IOException {
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig var1) throws Exception {

	}

	@Override
	public void destroy() {

	}
}
