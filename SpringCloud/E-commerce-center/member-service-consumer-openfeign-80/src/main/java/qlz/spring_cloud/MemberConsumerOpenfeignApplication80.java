package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-07 23:13
 * @description:
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
public class MemberConsumerOpenfeignApplication80 {
	public static void main(String[] args) {
		SpringApplication.run(MemberConsumerOpenfeignApplication80.class, args);
	}
}
