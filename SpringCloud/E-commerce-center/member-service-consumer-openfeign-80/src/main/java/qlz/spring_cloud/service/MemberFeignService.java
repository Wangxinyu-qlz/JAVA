package qlz.spring_cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.entity.Result;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-07 23:15
 * @description:
 **/
@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {
	@GetMapping(value = "/member/get/{id}")
	Result<Member> getMemberById(@PathVariable("id") Long id);
}
