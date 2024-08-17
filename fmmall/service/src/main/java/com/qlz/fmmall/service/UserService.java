package com.qlz.fmmall.service;

import com.qlz.fmmall.vo.ResultVO;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 20:14
 * @description:
 **/
public interface UserService {
	public ResultVO checkLogin(String name, String pwd);
}
