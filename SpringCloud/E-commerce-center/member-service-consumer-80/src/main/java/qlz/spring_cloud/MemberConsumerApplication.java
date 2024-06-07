package qlz.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 09:30
 * @description:
 **/
//如果 member-service-consumer-80 启动报错: springBoot 启动 If you want an embedded
//database (H2, HSQL or Derby), please put it on the classpath.
//加入排除 DataSourceAutoConfiguration 自动配置
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient  //启用服务发现
public class MemberConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MemberConsumerApplication.class, args);
	}
}
