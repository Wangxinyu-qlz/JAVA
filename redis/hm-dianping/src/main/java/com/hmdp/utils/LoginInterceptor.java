package com.hmdp.utils;

import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-23 20:37
 * @description:
 **/
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取session
		HttpSession session = request.getSession();
		//获取session中的用户
		Object user = session.getAttribute("user");
		//判断用户是否存在
		if(user == null) {
			//没有，拦截，返回 401 状态码
			response.setStatus(401);
			return false;
		}
		//有用户，保存用户信息到 ThreadLocal 保存在当前的线程中
		UserHolder.saveUser((UserDTO) user);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		//移除用户，避免内存泄漏
		UserHolder.removeUser();
	}
}
