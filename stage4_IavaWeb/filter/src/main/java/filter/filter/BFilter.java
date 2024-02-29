package filter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 17:01
 * @description:
 **/
public class BFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("BFilter--->线程ID=" + Thread.currentThread().getId());

		System.out.println("BFilter::doFilter() 的前置代码");
		System.out.println("执行 BFilter::doFilter()");
		chain.doFilter(request, response);
		System.out.println("BFilter::doFilter() 的后置代码");
	}

	@Override
	public void destroy() {

	}
}
