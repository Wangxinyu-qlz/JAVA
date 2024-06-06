package qlz.spring_cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 09:36
 * @description: 说明:
 * MEMBER-SERVICE-PROVIDER 目前有两个Availability Zones
 * member-service-provider:10002 , member-service-provider:10000
 * * 所以如果你还需要使用注解@LoadBalanced 赋予RestTemplate 负载均衡的能力
 */
@Configuration
public class CustomizationBean {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
