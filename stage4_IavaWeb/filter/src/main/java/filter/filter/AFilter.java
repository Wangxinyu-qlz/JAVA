package filter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 16:59
 * @description:
 **/
public class AFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AFilter--->线程ID=" + Thread.currentThread().getId());
		/**
		 * 多个filter共同执行时，所有的过滤器使用同一个request对象
		 * 多个过滤器的执行顺序和web.xml文件中的配置顺序一致
		 * TODO Filter链的执行顺序
		 * AFilter--->线程ID=319             这个线程在每次请求页面的时候都会刷新
		 * AFilter::doFilter() 的前置代码
		 * 执行 AFilter::doFilter()
		 * BFilter--->线程ID=319
		 * BFilter::doFilter() 的前置代码
		 * 执行 BFilter::doFilter()
		 * BFilter::doFilter() 的后置代码
		 * AFilter::doFilter() 的后置代码
		 */
		System.out.println("AFilter::doFilter() 的前置代码");
		System.out.println("执行 AFilter::doFilter()");
		chain.doFilter(request, response);//此处将执行下一个过滤器的dopFilter()方法，如果没有了，就执行目标资源
		System.out.println("AFilter::doFilter() 的后置代码");
	}

	@Override
	public void destroy() {

	}
}
