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
	public static final String
	MEMBER_SERVICE_PROVIDER_URL = "http://localhost:10002";
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
