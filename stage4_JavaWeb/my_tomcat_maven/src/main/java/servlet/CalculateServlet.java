package servlet;

import utils.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/calculate"})
public class CalculateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接收提交的数据进行计算
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		int num1 = WebUtils.parerInt(strNum1, 0);
		int num2 = WebUtils.parerInt(strNum2, 0);
		int result = num1 + num2;

		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(num1 + "+" + num2 + "=" + result);

		writer.flush();
		writer.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
}
