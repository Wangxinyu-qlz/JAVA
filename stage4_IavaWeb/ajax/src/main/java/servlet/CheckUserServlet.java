package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ajax.entity.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import service.UserService;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 20:29
 * @description:
 **/
public class CheckUserServlet extends HttpServlet {
	@Test
	public void testStringIsNullOrEmpty() {
		String s = "";
		String t = null;
		if(s.isEmpty()) {
			System.out.println("s is empty");//s is empty
		}
		if(s == null) {
			System.out.println("s is null");
		} else {
			System.out.println("s is not null");//s is not null
		}
		//if(t.isEmpty()) {//Error: NullPointerException
		//	System.out.println("t is empty");
		//}
		if(t == null) {
			System.out.println("t is null");//t is null
		}
	}
	private UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("CheckUserServlet::doPost()");
		//接收ajax发送的数据
		String username = req.getParameter("ajax_username");
		System.out.println("username=" +username);

		resp.setContentType("text/html;charset=utf-8");

		//if ("qwe".equals(username)) {//不能使用king用户名
		//	User king = new User(100, "king", "000000", "king@qq.com");
		//	System.out.println(king);//ajax.entity.User@33e4f96b
		//	//TODO 原因：找不到com.google.gson.Gson，要通过mvnrepository.com查找相关的包，然后在pom.xml中配置
		//	String json = new Gson().toJson(king);//此处有Bug无法执行到此处
		//	System.out.println(json);
		//	resp.getWriter().write(json);
		//} else {//可以使用
		//	resp.getWriter().write("");
		//}

		//连接MySQL数据库 -> 需要在此类中new一个属性：UserService
		//到数据库中查询，查到返回user对象，没查到返回""（注意是空字符串而不是null）
		User user = userService.getUserByName(username);
		if(user != null) {//说明用户名存在，返回该user的Json格式数据（String）
			String userJson = new Gson().toJson(user);
			resp.getWriter().write(userJson);
		} else {
			resp.getWriter().write("");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
