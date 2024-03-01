package filter.filter;

import javax.crypto.spec.IvParameterSpec;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 12:39
 * @description: 在web工程启动时，filter实例由 tomCat创建，同时会创建一个FilterConfig对象，
 * 会创建filter默认的无参构造器，同时调用init()方法
 * tomCat创建filter实例时，同时会创建一个FilterConfig对象，通过init()方法传入
 * 通过FilterConfig对象，可以获取filter的配置信息
 * 当一个http请求和filter的url-pattern匹配时，就会调用doFilter()方法
 * 调用doFilter()方法的同时，tomcat会同时创建ServletRequest,ServletResponse,FilterChain对象
 * 并通过doFilter()方法传入
 * 如果后面的请求资源(jsp/servlet...)会用到request和response，会继续传递
 **/
public class ManageFilter implements Filter {
	private int count = 0;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//当TomCat创建Filter后，会调用该方法进行初始化
		System.out.println("ManageFilter ~~~~~~~init()被调用....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//每次访问"http://localhost:8080/filter/manage/admin.jsp",此处的次数都会累加
		System.out.println("doFilter()被调用的次数=" + (++count));

		//每次调用该Filter时，doFilter()方法被调用
		System.out.println("ManageFilter ~~~~~~~~doFilter()方法被调用");

		//TODO 如果这里没有调用继续请求的方法，就会停止在此处  表现为：直接访问被过滤的资源，会访问不到，空白的
		//如果继续访问目标资源，需要调用	FilterChain
		//在调用过滤器前，request已经被创建并封装
		//这里可以通过 request 获取很多信息：访问url，session，访问的参数
		//可以做事务管理，数据获取，日志管理等
		//request.getParameter("");

		// httpServletRequest 还可继续使用
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//获取session 还可以继续使用
		HttpSession session = httpServletRequest.getSession();
		//session.setMaxInactiveInterval(3);
		Object username = session.getAttribute("username");
		if(username != null) {//登陆成功过，直接放行
			//1.继续访问目标资源
			//2.request 和 response对象会传递给目标资源/文件
			//3.一定要理解filter传递的两个对象，在后面的servlet、jsp 是同一个对象（在一次http请求中）
			//实验方法：
			//  1.通过 http://localhost:8080/filter/login.jsp 正常登录
			//  2.通过 http://localhost:8080/filter/manage/admin.jsp 直接访问
			//  3.后台即输出：
			//          登陆成功request=org.apache.catalina.connector.RequestFacade@769c4a8a
			//          admin.jsp:  request=org.apache.catalina.connector.RequestFacade@769c4a8a
			//注意：如果设置了session的生命周期，session.setMaxInactiveInterval(3)，1和2的间隔不要超过这个时间，
			// 否则看不到3的输出结果，只会输出没登录过/登录失效request=org.apache.catalina.connector.RequestFacade@769c4a8a
			System.out.println("登陆成功request=" + request);
			chain.doFilter(request, response);
		} else {//没有登陆过，让他去登录
			System.out.println("没登录过/登录失效request=" + request);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	@Override
	public void destroy() {

	}
}
