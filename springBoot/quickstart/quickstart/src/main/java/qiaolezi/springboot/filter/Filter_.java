package qiaolezi.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 16:15
 * @description:  TODO 会经过SpringBoot拦截器
 **/
@Slf4j
@WebFilter(urlPatterns = {"/css/*", "/images/*"})
public class Filter_ implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("***************Filter_::doFilter*****************");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("***************Filter_::init*****************");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		log.info("***************Filter_::destroy*****************");
		Filter.super.destroy();
	}
}
