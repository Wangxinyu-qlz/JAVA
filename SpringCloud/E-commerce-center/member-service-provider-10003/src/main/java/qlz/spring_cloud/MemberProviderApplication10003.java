package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 15:47
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class MemberProviderApplication10003 {
	public static void main(String[] args) {
		SpringApplication.run(MemberProviderApplication10003.class, args);
	}
}
