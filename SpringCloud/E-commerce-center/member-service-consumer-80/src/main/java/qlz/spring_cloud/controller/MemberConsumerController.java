package qlz.spring_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.entity.Result;

import javax.annotation.Resource;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 09:37
 * @description:
 **/
@RestController
@Slf4j
public class MemberConsumerController {
	/**
	 * 1. MEMBER-SERVICE-PROVIDER 就是服务提供方[集群]注册到 EurekaServer 的名称
	 * 2. 也就是服务提供方[集群] 对外暴露的名称为 MEMBER-SERVICE-PROVIDER
	 * 3. MEMBER-SERVICE-PROVIDER 目 前 有 两 个 Availability Zones:
	 * member-service-provider:10002 , member-service-provider:10000
	 * 所以如果你还需要使用注解@LoadBalanced 赋予 RestTemplate 负载均衡的能力, [即选
	 * 择 MEMBER-SERVICE-PROVIDER 某一个服务访问, 否则就会报错, 可以给学员演示一下
	 * 4. 具体方法
	 * @Configuration public class CustomizationBean {
	 * @Bean
	 * @LoadBalanced public RestTemplate getRestTemplate() {
	 * return new RestTemplate();
	 *     }
	 * }
	 */
	public static final String
			//MEMBER_SERVICE_PROVIDER_URL = "http://localhost:10002";
	//集群配置
	//这里的名字就是spring.application.name: member-service-provider
	MEMBER_SERVICE_PROVIDER_URL = "http://MEMBER-SERVICE-PROVIDER";
	@Resource
	private RestTemplate restTemplate;

	@PostMapping("/member/consumer/save")
	public Result<Member> save(Member member) {
		//url, member:请求参数, Result.class:http响应被转换的对象类型
		return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL +
				"/member/save", member, Result.class);
	}

	@GetMapping("/member/consumer/get/{id}")
	public Result<Member> get(@PathVariable("id")Long id) {
		return restTemplate.getForObject(MEMBER_SERVICE_PROVIDER_URL +
				"/member/get/" + id, Result.class);
	}
}
