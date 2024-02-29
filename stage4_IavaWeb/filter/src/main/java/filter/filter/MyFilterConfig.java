package filter.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 16:24
 * @description:
 * 演示FilterConfig使用
 **/
public class MyFilterConfig implements Filter {
	private String forbid_ip = "";//从配置获取的ip
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filterName = filterConfig.getFilterName();
		forbid_ip = filterConfig.getInitParameter("ip");
		String port = filterConfig.getInitParameter("port");
		System.out.println("过滤器的名字：" + filterName + " IP:" + forbid_ip + " 端口：" + port);
		//可以在多个会话之间通讯
		ServletContext servletContext = filterConfig.getServletContext();
		System.out.println(servletContext);

		//获取到所有的配置参数名
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		//遍历
		while (initParameterNames.hasMoreElements()) {
			System.out.println("名字=" + initParameterNames.nextElement());
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//通过forbid_ip进行控制
		String remoteAddr = request.getRemoteAddr();
		if(remoteAddr.contains(forbid_ip)) {//不能访问
			System.out.println("封杀");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;//直接返回，不往下走
		}
		//继续访问
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
