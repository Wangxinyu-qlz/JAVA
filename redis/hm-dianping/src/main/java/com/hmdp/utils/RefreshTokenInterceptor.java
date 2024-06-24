package com.hmdp.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hmdp.dto.UserDTO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-24 11:59
 * @description:
 **/
public class RefreshTokenInterceptor implements HandlerInterceptor {
	//这里借助MvcConfig类中配置的拦截器，注入StringRedisTemplate
	private StringRedisTemplate stringRedisTemplate;

	public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取请求头中的token
		String token = request.getHeader("authorization");
		//token 判空
		if (StringUtils.isBlank(token)) {
			return true;//没有登录就放行，交给下一个拦截器处理
		}
		//基于token获取redis中的用户信息
		String key = RedisConstants.LOGIN_USER_KEY + token;
		Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(key);
		//判断用户是否存在
		if (userMap.isEmpty()) {
			return true;//没有登录就放行，交给下一个拦截器处理
		}
		//将查询到的user数据转换为UserDTO
		UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
		//存在，保存到ThreadLocal
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
