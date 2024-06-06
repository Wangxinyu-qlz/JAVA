package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 17:36
 * @description:
 **/
//标识为 Eureka Client
@EnableEurekaClient
@SpringBootApplication
public class MemberProviderApplication10002 {
	public static void main(String[] args) {
		SpringApplication.run(MemberProviderApplication10002.class, args);
	}
}
