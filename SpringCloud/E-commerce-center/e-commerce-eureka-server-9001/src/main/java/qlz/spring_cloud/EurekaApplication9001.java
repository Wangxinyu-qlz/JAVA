package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 11:22
 * @description:
 **/
//该程序作为Eureka Server
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication9001 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication9001.class, args);
	}
}
