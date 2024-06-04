package qiaolezi.springboot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 10:28
 * @description:
 **/
@Component
public class MyFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("doFilter...");
		filterChain.doFilter(servletRequest, servletResponse);//TODO 放行
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
