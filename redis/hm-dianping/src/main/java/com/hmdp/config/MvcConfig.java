package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-23 21:07
 * @description:
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns(
						"/user/code",
						"/user/login",
						"/blog/hot",
						"/shop/**",
						"/shop-type/**",
						"/upload/**",
						"/voucher/**"
				);
	}
}
