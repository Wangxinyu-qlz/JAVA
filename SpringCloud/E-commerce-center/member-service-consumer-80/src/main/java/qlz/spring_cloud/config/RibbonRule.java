package qlz.spring_cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-07 22:55
 * @description:
 **/
@Configuration
public class RibbonRule {
	@Bean
	public IRule myRibbonRule() {
		return new RandomRule();//使用随机负载均衡算法
	}
}
