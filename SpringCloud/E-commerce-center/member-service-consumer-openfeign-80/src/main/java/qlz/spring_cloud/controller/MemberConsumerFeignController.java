package qlz.spring_cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.entity.Result;
import qlz.spring_cloud.service.MemberFeignService;

import javax.annotation.Resource;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-07 23:18
 * @description:
 **/
@RestController
public class MemberConsumerFeignController {
	@Resource
	private MemberFeignService memberFeignService;

	@GetMapping(value = "/member/consumer/openfeign/get/{id}")
	public Result<Member> getMemberById(@PathVariable("id") Long id) {
		return memberFeignService.getMemberById(id);
	}
}
