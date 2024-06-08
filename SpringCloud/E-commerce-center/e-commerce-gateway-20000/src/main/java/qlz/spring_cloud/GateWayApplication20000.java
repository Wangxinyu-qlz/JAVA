package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-08 11:24
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication20000 {
	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication20000.class, args);
	}
}
