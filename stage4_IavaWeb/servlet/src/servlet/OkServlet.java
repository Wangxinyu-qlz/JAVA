package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Java
 * @description: 注解配置Servlet
 * @author: Qiaolezi
 * @create: 2024-02-24 14:52
 **/
/*
*   @Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented => 在 javadoc 工具生成文档时会有记录
	public @interface WebServlet {
	    String name() default "";

	    String[] value() default {};

	    String[] urlPatterns() default {};

	    int loadOnStartup() default -1;

	    WebInitParam[] initParams() default {};

	    boolean asyncSupported() default false;

	    String smallIcon() default "";

	    String largeIcon() default "";

	    String description() default "";

	    String displayName() default "";
	}
	* urlPatterns() 对应 web.xml 的 <url-pattern>name</url-pattern>
	* {"/ok1", "/ok2"} 可以给 OkServlet 配置多个 url-pattern
	* 相当于 @WebServlet(urlPatterns = {"/ok1", "/ok2"}) 代替web.xml 的配置
	* 浏览器访问 OkServlet 时，可以 http://localhost:8080/servlet/ok1 或者 http://localhost:8080/servlet/ok1
	* web.xml 中的 init-param 在住注解的指定方式
	*       <init-param>
                <param-name></param-name>
                <param-value></param-value>
            </init-param>
    *   init-param 可用于：配置数据库连接信息  配置配置文件路径  配置其他自定义参数
    *   "/ok1/*"  --> 可以使用/ok1/aa  /ok1/bb  /ok1/cc  /ok1/cc/qq(多级目录) 等进行访问
    *   "*.action"（绝对不能有/）--> 可以使用aa.action bb.action 等进行访问
    *   "/" "/*" 全匹配 -->任意路径都能访问，当时此配置会覆盖tomcat的DefaultServlet，
    *   该Servlet是处理静态资源的，一旦被拦截，静态资源不能处理，如
    *   http://localhost:8080/servlet/register.html  会显示空白界面
    *
    *   路径查询优先级：精确路径 -> 目录路径 -> 扩展名路径 -> /* -> /
 */
@WebServlet(urlPatterns = {"/ok1", "/ok2"}, name = "test", loadOnStartup = 1,
		initParams = {@WebInitParam(name="xx", value="yy"), @WebInitParam(name="aa", value="bb")})
public class OkServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("注解方式 OkServlet:init()被调用");
	}

	/**
	 * 处理doPost请求
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("OkServlet:doGet()注解方式");
	}

	/**
	 * 处理doPost请求
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("OkServlet:doPost()注解方式");
	}
}
