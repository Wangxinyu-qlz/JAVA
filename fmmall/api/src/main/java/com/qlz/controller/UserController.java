package com.qlz.controller;

import com.qlz.fmmall.service.UserService;
import com.qlz.fmmall.service.impl.UserServiceImpl;
import com.qlz.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/login")
	public ResultVO login(String name, String pwd) {
		return userService.checkLogin(name, pwd);
	}
}
