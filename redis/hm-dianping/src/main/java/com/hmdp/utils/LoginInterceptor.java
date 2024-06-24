package com.hmdp.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-23 20:37
 * @description:
 **/
public class LoginInterceptor implements HandlerInterceptor {
	//这里借助MvcConfig类中配置的拦截器，注入StringRedisTemplate
	private StringRedisTemplate stringRedisTemplate;

	public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		////获取session
		//HttpSession session = request.getSession();
		////获取session中的用户
		//Object user = session.getAttribute("user");
		////判断用户是否存在
		//if(user == null) {
		//	//没有，拦截，返回 401 状态码
		//	response.setStatus(401);
		//	return false;
		//}
		////有用户，保存用户信息到 ThreadLocal 保存在当前的线程中
		//UserHolder.saveUser((UserDTO) user);
		//return true;

		//获取请求头中的token
		String token = request.getHeader("authorization");
		//判断token是否为空
		if(StrUtil.isBlank(token)) {
			response.setStatus(401);//未授权错误
			return false;
		}
		//基于token获取redis中的用户信息
		String key = RedisConstants.LOGIN_USER_KEY + token;
		Map<Object, Object> userMap = stringRedisTemplate.opsForHash().
				entries(key);
		//判断用户是否存在
		if(userMap.isEmpty()) {
			response.setStatus(401);//未授权错误
			return false;
		}
		//将查询到的Hash数据转换为UserDTO对象
		UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
		//存在，保存用户信息到ThreadLocal
		UserHolder.saveUser(userDTO);
		//刷新token有效期
		stringRedisTemplate.expire(key, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		//移除用户，避免内存泄漏
		UserHolder.removeUser();
	}
}
