package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: Java
 * @description: 演示开发Servlet
 * @author: Qiaolezi
 * @create: 2024-02-23 22:41
 * 开发一个Servlet需要实现Servlet接口
 * 实现Servlet接口的方法
 **/
public class HelloServlet implements Servlet {
	private int count = 0;
	public static void main(String[] args) {

	}

	/**
	 * 初始化 servlet
	 * 当 TomCat创建 HelloServlet 实例的时候，会创建 init方法
	 * 该方法只会别调用一次
	 * @param servletConfig
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("HelloServlet init()方法被调用！");
	}

	/**
	 * 返回 ServletConfig，即配置
	 * @return
	 */
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	/**
	 * 该方法处理浏览器的请求，包括GET和POST
	 * 浏览器每次请求 Servlet时，该方法均会被调用
	 * 当 TomCat 调用该方法时，会将 http 请求封装为实现了 ServletRequest 接口的 request 对象
	 * 通过 servletResponse 对象，可以得到用户提交的数据
	 * ServletResponse：可以用于返回数据给 TomCat->浏览器
	 * @param servletRequest
	 * @param servletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		count++;
		//如果每次刷新界面，count值在累计，说明 HelloServlet 是单例的
		System.out.println("service方法被调用！count=" + count);

		//每次刷新id都不一样，TomCat每次处理一次 http 请求都会 new 一个线程
		System.out.println("当前线程的id=" + Thread.currentThread().getId());

		//思考：从 servletRequest 对象获取请求方法->
		//ServletRequest没有->子接口->子接口和实现了该接口的子类
		//HttpServletRequest接口:getMethod()

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String method = httpServletRequest.getMethod();
		//System.out.println(method);//GET
		if("GET".equals(method)) {
			doGet();
		} else if("POST".equals(method)) {
			doPost();
		}
	}

	/**
	 * 用于响应 Get 请求
	 */
	public void doGet() {
		System.out.println("doGet()被调用");
	}

	/**
	 * 用于响应 Post 请求
	 */
	public void doPost() {
		System.out.println("doPost()被调用");
	}

	/**
	 * 返回 servlet信息 （使用较少）
	 * @return
	 */
	@Override
	public String getServletInfo() {
		return null;
	}

	/**
	 * 该方法用于销毁 servlet 实例，被 TomCat 调用，只调用一次
	 * 当web应用被终止 or Servlet 容器终止运行 or Servlet 类重新装载 此方法被调用
	 * 比如重启 TomCat，或者重新部署(redeploy) web 应用
	 */
	@Override
	public void destroy() {
		System.out.println("destroy()方法被调用");
	}
}
