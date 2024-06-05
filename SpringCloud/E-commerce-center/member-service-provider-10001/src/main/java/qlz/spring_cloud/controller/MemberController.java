package qlz.spring_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.entity.Result;
import qlz.spring_cloud.service.MemberService;

import javax.annotation.Resource;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 18:06
 * @description:
 **/
@RestController
@Slf4j
public class MemberController {
	@Resource
	private MemberService memberService;

	@PostMapping("/member/save")
	public Result save(Member member) {
		int affectedRows = memberService.save(member);
		if(affectedRows > 0) {
			return Result.success("添加会员成功", affectedRows);
		} else {
			return Result.error("401", "添加会员失败");
		}
	}
}
