package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import com.hmdp.utils.RefreshTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-23 21:07
 * @description:
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//token刷新拦截器
		registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate))
				.addPathPatterns("/**")
				.order(0);//设置为高优先级

		//登录拦截器
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
				)
				.order(1);
	}
}
