package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 14:46
 * @description:
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication9002 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication9002.class, args);
	}
}
