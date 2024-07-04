package com.hmdp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.Follow;
import com.hmdp.mapper.FollowMapper;
import com.hmdp.service.IFollowService;
import com.hmdp.utils.UserHolder;
import io.netty.handler.ssl.util.FingerprintTrustManagerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {
	@Override
	public Result follow(Long followUserId, Boolean isFollow) {
		//获取当前登录的用户信息
		Long userId = UserHolder.getUser().getId();
		//判断是关注/取关
		if (isFollow) {
			//关注，添加
			Follow follow = new Follow();
			follow.setFollowUserId(followUserId);
			follow.setUserId(userId);
			save(follow);
		} else {
			System.out.println(userId + "  " + followUserId);
			//取关，删除 delete from tb_follow where userId=? and follow_user_id=?
			remove(new QueryWrapper<Follow>()
					.eq("user_id", userId)
					.eq("follow_user_id", followUserId));
		}
		return Result.ok(followUserId);
	}

	@Override
	public Result isFollow(Long followUserId) {
		//获取当前登录的用户信息
		Long userId = UserHolder.getUser().getId();
		//查询是否关注
		Integer count = query().eq("user_id", userId).eq("follow_user_id", followUserId).count();
		//判断是否关注
		return Result.ok(count > 0);
	}
}
