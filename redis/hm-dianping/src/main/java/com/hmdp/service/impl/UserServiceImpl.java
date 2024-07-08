package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.*;
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
	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public Result sendCode(String phone, HttpSession session) {
		//1.校验手机号
		if (RegexUtils.isPhoneInvalid(phone)) {
			//2.返回错误信息
			return Result.fail("手机号格式错误");
		}
		//3.符合，生成验证码
		String code = RandomUtil.randomNumbers(6);
		//4.保存验证码到session -> redis
		//session.setAttribute(CODE, code);
		stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);//添加前缀区分业务
		//5.发送验证码
		log.debug("发送验证码成功，验证码：{}", code);
		//返回OK
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
		//2.校验验证码 -> 从redis 获取验证码并校验
		//Object cacheCode = session.getAttribute(CODE);
		String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
		String code = loginForm.getCode();
		if(cacheCode == null || !cacheCode.equals(code)) {
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

		//7.保存用户信息到session -> redis
		//TODO 需要考虑的问题：
		// 选择合适的数据结构（简单用String 对象用Hash，减少空间占用，可以存储单个字段，灵活）
		// 合适的key（唯一性，方便查找）
		// 设置有效期，避免占用过长时间
		// 合适的存储粒度，只存储必要信息（UserDTO），减少空间占用，不存储敏感信息
		//session有唯一id，保存在cookies中
		//session.setAttribute("user", user);//敏感信息会返回给前端，无关信息多，tomcat压力大
		//session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
		//7.1随机生成token，作为登录令牌
		String token = UUID.randomUUID().toString(true);
		//7.2将User对象转换为HashMap存储
		//class java.lang.Long cannot be cast to class java.lang.String
		// (java.lang.Long and java.lang.String are in module java.base of loader 'bootstrap')
		//UserDTO::Long id -> redis String ERROR
		UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
		Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),
				CopyOptions.create().
						setIgnoreNullValue(true).
						setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
		String tokenKey = LOGIN_USER_KEY + token;
		stringRedisTemplate.opsForHash().putAll(tokenKey, userMap);
		//7.3设置有效期
		stringRedisTemplate.expire(tokenKey, LOGIN_USER_TTL, TimeUnit.MINUTES);
		//7.4存储
		//这里不返回的话，前端会一直跳转回登录界面，
		// 注意要返回token，而不是tokenKey（这只是存储在redis中的字段名）
		//7.5返回token
		return Result.ok(token);
	}

	private User createUserWithPhone(String phone) {
		User user = new User();
		user.setPhone(phone);
		user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
		//保存
		save(user);
		return user;
	}

	@Override
	public Result sign() {
		//获取用户和日期
		Long userId = UserHolder.getUser().getId();
		LocalDateTime now = LocalDateTime.now();
		//拼接key
		String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
		String key = USER_SIGN_KEY + userId + keySuffix;
		//获取今天是本月的第几天
		int dayOfMonth = now.getDayOfMonth();
		stringRedisTemplate.opsForValue().setBit(key, dayOfMonth - 1, true);
		return Result.ok();
	}

	@Override
	public Result signCount() {
		//获取用户和当前日期
		Long userId = UserHolder.getUser().getId();
		LocalDateTime now = LocalDateTime.now();
		//拼接key
		String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
		String key = USER_SIGN_KEY + userId + keySuffix;
		int dayOfMonth = now.getDayOfMonth();
		List<Long> result = stringRedisTemplate.opsForValue().bitField(
				key,
				BitFieldSubCommands.create()
						.get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth)).valueAt(0)
		);
		if(result == null || result.isEmpty()) {
			return Result.ok(0);
		}
		Long num = result.get(0);
		if(num == null || num == 0) {
			return Result.ok(0);
		}
		int count = 0;
		//遍历
		while(true) {
			if((num & 1) ==0) {//没有签到，结束
				break;
			} else {//计数器+1
				count++;
			}
			//数字右移一位，并抛弃最后一个bit位，继续下一个bit位
			num >>>= 1;
		}
		return Result.ok(count);
	}
}
