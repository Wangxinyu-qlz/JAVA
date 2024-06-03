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
				.excludePathPatterns("/", "/login", "/index.html", "/images/**", "/upload.html", "/upload", "/public/**");
	}
}
