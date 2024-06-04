package qiaolezi.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import qiaolezi.springboot.filter.Filter_;
import qiaolezi.springboot.servlet.Listener_;
import qiaolezi.springboot.servlet.Servlet_;

import java.util.Arrays;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 17:22
 * @description:
 **/
@Configuration(proxyBeanMethods = true)
public class RegisterConfig_ {
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		Servlet_ servlet_ = new Servlet_();
		return new ServletRegistrationBean(servlet_, "/servlet01", "/servlet02");
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		Filter_ filter_ = new Filter_();
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter_);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/images/*", "/css/*", "/js/*"));
		return filterRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean listenerRegistrationBean() {
		Listener_ listener_ = new Listener_();
		return new ServletListenerRegistrationBean(listener_);
	}
}
