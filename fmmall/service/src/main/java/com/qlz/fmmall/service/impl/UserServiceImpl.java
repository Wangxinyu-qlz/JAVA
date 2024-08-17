package com.qlz.fmmall.service.impl;

import com.qlz.fmmall.dao.UserDao;
import com.qlz.fmmall.entity.User;
import com.qlz.fmmall.service.UserService;
import com.qlz.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 20:17
 * @description:
 **/
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public ResultVO checkLogin(String name, String pwd) {
		User user = userDao.queryByName(name);

		if(user == null) {
			//用户不存在
			return new ResultVO(404, "用户不存在", null);
		} else {
			//对输入的密码进行加密
			//使用加密后的密码 和 user中的密码比较
			if(user.getUserPwd().equals(pwd)) {
				//验证成功
				return new ResultVO(200, "登陆成功", user);

			} else {
				//密码错误
				return new ResultVO(404, "密码错误", null);
			}
		}
	}
}
