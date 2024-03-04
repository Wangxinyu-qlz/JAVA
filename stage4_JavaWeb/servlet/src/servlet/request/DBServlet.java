package servlet.request;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Java
 * @description: TODO 演示ServletConfig
 * @author: Qiaolezi
 * @create: 2024-02-25 16:30
 **/
@WebServlet(value = {"/registerServlet"},
		initParams = {@WebInitParam(name = "username", value = "root"),
				      @WebInitParam(name = "password", value = "123456")})
public class DBServlet extends HttpServlet {
	/**
	 * 1. DBServlet初始化时，同时创建 ServletConfig 对象
	 * 2. 如果DBServlet: init()方法存在super.init(config);->会调用GenericServlet:inti()方法：
	 *     public void init(ServletConfig config) throws ServletException {
	 *         this.config = config;
	 *         this.init();
	 *     }
	 *     将 TomCat 创建的 ServletConfig 对象赋值给会调用GenericServlet的属性private transient ServletConfig config;
	 *     如果没有super.init(config)，父类中的属性private transient ServletConfig config;为null
	 *     那么在DBServlet类中，doPost()和doGet()方法无法使用ServletConfig
	 * 3. 如果重写init()方法，想要在其他方法中通过getServletConfig() 方法获取 ServletConfig对象，
	 *    一定要  super.init(config);
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init" + config);//initorg.apache.catalina.core.StandardWrapperFacade@75803de5
		/*
		* 如果super.init(config);被注释掉，网页报错：
		* HTTP Status 500 -type Exception report
		  message
			description The server encountered an internal error that prevented it from fulfilling this request.
		  exception
			java.lang.NullPointerException
			servlet.request.DBServlet.doPost(DBServlet.java:31)
			servlet.request.DBServlet.doGet(DBServlet.java:37)
			javax.servlet.http.HttpServlet.service(HttpServlet.java:622)
			javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
			org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	* */
		super.init(config);//桥梁作用：此处config -> GenericServlet中的config -> 其他方法中的config
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		//public abstract class GenericServlet: private transient ServletConfig config;
		//transient：该关键字修饰的变量不会被 串行化，如果这个信息很重要，不希望保存到文件，就用此关键字修饰
		ServletConfig servletConfig = getServletConfig();
		System.out.println(servletConfig);//null(没有super.init(config);时返回null)  org.apache.catalina.core.StandardWrapperFacade@75803de5
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		System.out.println("初始化参数：username:" + username + " password:" + password);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
}
