package qiaolezi.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import qiaolezi.springboot.interceptor.LoginInterceptor;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 17:19
 * @description:
 **/
@Configuration(proxyBeanMethods = false)
public class WebConfig2 implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//  /** 拦截所有请求
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/**")
				//指定要放行的路径 TODO 登陆界面的图片也需要放行
				.excludePathPatterns("/", "/login", "/index.html", "/images/**", "/upload.html", "/upload", "/public/**")
				//如果只放行/xxx，访问/xxx找不到资源会去调度/error，但是/error是被拦截的状态，所以会重定向到登录界面
				.excludePathPatterns("/xxx", "/error")
				//注意: 过滤器配置的urlPatterns 也会经过Spring-Boot 拦截器(根据拦截器的规则)
				//所以为了看到效果，请在拦截器配置放行 /css/**
				//在servlet 匹配全部是 /*, 在Spring-Boot 是/**
				.excludePathPatterns("/css/**");
	}
}
