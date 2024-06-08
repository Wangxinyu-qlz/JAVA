package qlz.spring_cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-08 17:19
 * @description:
 **/
//@Configuration
public class RibbonRule {
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
