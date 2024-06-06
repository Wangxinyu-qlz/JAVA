package qlz.spring_cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 09:36
 * @description:
 **/
@Configuration
public class CustomizationBean {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
