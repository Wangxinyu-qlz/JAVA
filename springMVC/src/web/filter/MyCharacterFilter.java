package web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 20:40
 * @description:
 **/
public class MyCharacterFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		//加入对中文编码的处理
		servletRequest.setCharacterEncoding("UTF-8");
		//放行请求
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {}
}
