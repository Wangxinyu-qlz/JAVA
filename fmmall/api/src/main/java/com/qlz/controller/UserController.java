package com.qlz.controller;

import com.qlz.fmmall.service.UserService;
import com.qlz.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 20:55
 * @description:
 **/
@Controller
@ResponseBody  //返回的都是Json数据
@RequestMapping("/user")
@Api(value = "用户登录、退出等操作", tags = "用户管理")
public class UserController {
	@Resource
	private UserService userService;

	@Value("${token.header}")
	private String header;

	@ApiOperation("用户登录")
	@GetMapping("/login")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "sting", name = "name", value = "账号", required = true),
			@ApiImplicitParam(dataType = "sting", name = "pwd", value = "密码", required = false, defaultValue = "1111")
	})
	public ResultVO login(String name, String pwd) {
		System.out.println("header");
		return userService.checkLogin(name, pwd);
	}
}