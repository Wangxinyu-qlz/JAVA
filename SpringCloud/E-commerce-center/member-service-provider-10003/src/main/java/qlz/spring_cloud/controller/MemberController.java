package qlz.spring_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.entity.Result;
import qlz.spring_cloud.service.MemberService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

	// 应该如何提交
	// 1．我们的前端如果是以json格式来发送添加信息Member，那么我们需要使用@RequestBody/，
	// 才能将数据封装到对应的bean，同时保证http的请求头的content-type是对应
	// 2．如果前端是以表单形式提交了，则不需要使用@RequestBody，才会进行对象参数封装，
	// 同时保证http的请求头的content-type是对应
	//TODO @RequestBody:解决通过member-service-consumer添加数据，数据库中为null
	// 可以将restTemplate发送的数据重新封装成Member
	@PostMapping("/member/save")
	public Result save(@RequestBody Member member) {
		int affectedRows = memberService.save(member);
		if(affectedRows > 0) {
			return Result.success("添加会员成功 member-service-provider-10003", affectedRows);
		} else {
			return Result.error("401", "添加会员失败");
		}
	}

	@GetMapping("/member/get/{id}")
	public Result getMemberById(@PathVariable("id")Long id){
		//模拟超时，这里暂停 5 秒
		//try {
		//	TimeUnit.SECONDS.sleep(5);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		Member member = memberService.queryMemberById(id);
		if(member != null) {
			return Result.success("查询成功 member-service-provider-10003", member);
		} else {
			return Result.error("402", "id=" +id + "不存在");
		}
	}
}
