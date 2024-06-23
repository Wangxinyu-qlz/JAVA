package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.hmdp.utils.SystemConstants.USER_NICK_NAME_PREFIX;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	private final String CODE = "code";
	@Override
	public Result sendCode(String phone, HttpSession session) {
		//1.校验手机号
		if (RegexUtils.isPhoneInvalid(phone)) {
			//2.返回错误信息
			return Result.fail("手机号格式错误");
		}
		//3.符合，生成验证码
		String code = RandomUtil.randomNumbers(6);
		//4.保存验证码到session
		session.setAttribute(CODE, code);
		//5.发送验证码
		log.debug("发送验证码成功，验证码：{}", code);
		//  返回OK
		return Result.ok();
	}

	@Override
	public Result login(LoginFormDTO loginForm, HttpSession session) {
		//1.校验手机号
		String phone = loginForm.getPhone();
		if (RegexUtils.isPhoneInvalid(phone)) {
			//2.返回错误信息
			return Result.fail("手机号格式错误");
		}
		//2.校验验证码
		Object cacheCode = session.getAttribute(CODE);
		String code = loginForm.getCode();
		if(cacheCode == null || !cacheCode.toString().equals(code)) {
			//3.不一致，报错
			return Result.fail("验证码错误");
		}
		// TODO 判断验证码是否对应于正确的手机号
		//4.一致，根据手机号查询用户
		User user = query().eq("phone", phone).one();
		//5.判断用户是否存在
		if(user == null) {
			//6.不存在，创建新用户，并保存
			user = createUserWithPhone(phone);
		}

		//6.保存用户信息到session
		//session有唯一id，保存在cookies中
		//session.setAttribute("user", user);//敏感信息会返回给前端，无关信息多，tomcat压力大
		session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
		//这里不返回的话，
		return Result.ok(user);
	}

	private User createUserWithPhone(String phone) {
		User user = new User();
		user.setPhone(phone);
		user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
		//保存
		save(user);
		return user;
	}
}
