package qiaolezi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import qiaolezi.springboot.bean.Car;
import qiaolezi.springboot.interceptor.LoginInterceptor;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 11:05
 * @description:
 **/
@Configuration(proxyBeanMethods = false)
public class WebConfig {
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addFormatters(FormatterRegistry registry) {
				//注册一个String->Car
				//仍然使用反射+注解+IO+动态代理那一套来玩，将该转换器注册到转换器converters 的容器中
				// (converters 底层是ConcurrentHashMap)
				registry.addConverter(new Converter<String, Car>(){
					@Override
					public Car convert(String source) {
						if(!ObjectUtils.isEmpty(source)) {
							Car car = new Car();
							String[] split = source.split(",");
							car.setName(split[0]);
							car.setPrice(Double.parseDouble(split[1]));
							return car;
						}
						return null;
					}
				});
			}
		};
	}

	//@Bean
	//public WebMvcConfigurer webMvcConfigurerInterceptor() {
	//	return new WebMvcConfigurer() {
	//		@Override
	//		public void addInterceptors(InterceptorRegistry registry) {
	//			registry.addInterceptor(new LoginInterceptor())
	//					.addPathPatterns("/**")
	//					.excludePathPatterns("/","/login","/images/**");
	//		}
	//	};
	//}
}
