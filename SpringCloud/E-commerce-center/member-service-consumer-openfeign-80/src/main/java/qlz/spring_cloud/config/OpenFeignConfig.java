package qlz.spring_cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-08 09:54
 * @description:
 **/
@Configuration
public class OpenFeignConfig {
	@Bean
	public Logger.Level feignLoggerLevel() {
		//日志级别返回FULL
		//日志级别
		//	NONE∶默认的，不显示任何日志
		//	BASIC∶仅记录请求方法、URL、响应状态码及执行时间;
		//	HEADERS∶除了BASIC中定义的信息之外，还有请求和响应的头信息;
		//	FULL∶除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
		return Logger.Level.FULL;
	}
}
