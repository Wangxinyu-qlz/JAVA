package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 14:27
 * @description:
 **/
public interface UserService {
	/**
	 * 微信登录
	 * @param userLoginDTO
	 * @return
	 */
	User wxLogin(UserLoginDTO userLoginDTO);
}
