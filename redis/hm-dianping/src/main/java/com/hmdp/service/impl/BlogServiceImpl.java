package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.dto.ScrollResult;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Blog;
import com.hmdp.entity.Follow;
import com.hmdp.entity.User;
import com.hmdp.mapper.BlogMapper;
import com.hmdp.service.IBlogService;
import com.hmdp.service.IFollowService;
import com.hmdp.service.IUserService;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hmdp.utils.RedisConstants.BLOG_LIKED_KEY;
import static com.hmdp.utils.RedisConstants.FEED_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private IBlogService blogService;
	@Resource
	private IUserService userService;
	@Resource
	private IFollowService followService;

	@Override
	public Result queryBlogById(Long id) {
		Blog blog = getById(id);
		if (blog == null) {
			return Result.fail("笔记不存在");
		}
		//查询blog有关的用户
		queryBlogUser(blog);
		//查询blog是否被点赞
		isBlogLiked(blog);
		return Result.ok(blog);
	}

	private void isBlogLiked(Blog blog) {
		UserDTO user = UserHolder.getUser();
		if(user == null) {
			//用户未登录，不需要查询是否点赞
			return;
		}
		Long userId = user.getId();
		String key = BLOG_LIKED_KEY + blog.getId();
		Double timeStamp = stringRedisTemplate.opsForZSet().score(key, userId.toString());
		blog.setIsLike(timeStamp != null);
	}

	private void queryBlogUser(Blog blog) {
		Long userId = blog.getUserId();
		User user = userService.getById(userId);
		blog.setName(user.getNickName());
		blog.setIcon(user.getIcon());
	}

	@Override
	public Result queryHotBlog(Integer current) {
		// 根据用户查询
		Page<Blog> page = blogService.query()
				.orderByDesc("liked")
				.page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
		// 获取当前页数据
		List<Blog> records = page.getRecords();
		// 查询用户
		records.forEach(blog -> {
			this.queryBlogUser(blog);
			this.isBlogLiked(blog);
		});
		return Result.ok(records);
	}

	@Override
	public Result likeBlog(Long id) {
		//获取登录用户
		Long userId = UserHolder.getUser().getId();
		//判断当前登录用户是否已经点赞
		String key = BLOG_LIKED_KEY + id;
		//查询时间戳
		Double timeStamp = stringRedisTemplate.opsForZSet().score(key, userId.toString());
		if (timeStamp == null) {
			//未点赞
			//数据库点赞数+1
			boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();
			//保存用户到redis集合 set  zadd key value score value score
			if (isSuccess) {
				stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
			}
		} else {
			//已点赞
			//数据库点赞数-1
			boolean isSuccess = update().setSql("liked = liked - 1").eq("id", id).update();
			//将用户从redis集合中移除
			if (isSuccess) {
				stringRedisTemplate.opsForZSet().remove(key, userId.toString());
			}
		}
		return Result.ok();
	}

	@Override
	public Result queryBlogLikes(Long id) {
		//查询top5的点赞用户 zrange key 0 4
		String key = BLOG_LIKED_KEY + id;
		Set<String> top5 = stringRedisTemplate.opsForZSet().range(key, 0, 4);
		if(top5 == null || top5.isEmpty()) {
			return Result.ok(Collections.emptyList());
		}
		//解析用户id
		List<Long> ids = top5.stream().map(Long::valueOf).collect(Collectors.toList());
		//根据用户id查询用户 where id in (5, 1)  order by field(id, 5, 1) 解决查询顺序反的问题
		String idStr = StrUtil.join(",", ids);
		List<UserDTO> userDTOS = userService.query().
				in("id", ids).last("order by field(id," + idStr + ")").list()
				.stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class))
				.collect(Collectors.toList());
		//返回
		return Result.ok(userDTOS);
	}

	@Override
	public Result saveBlog(Blog blog) {
		// 获取登录用户
		UserDTO user = UserHolder.getUser();
		blog.setUserId(user.getId());
		// 保存探店博文
		boolean isSuccess = blogService.save(blog);
		if(!isSuccess) {
			return Result.fail("新增笔记失败");
		}
		//查询笔记作者的所有粉丝 select * from tb_follow where follow_user_id = ?
		List<Follow> follows = followService.query().eq("follow_user_id", user.getId()).list();
		//推送笔记id给所有粉丝
		for(Follow follow : follows) {
			//获取粉丝id
			Long userId = follow.getUserId();
			//推送到sortedSet
			String key = FEED_KEY + userId;
			stringRedisTemplate.opsForZSet().add(key, blog.getId().toString(), System.currentTimeMillis());
		}
		// 返回id
		return Result.ok(blog.getId());
	}

	//滚动分页查询
	@Override
	public Result queryBlogOfFollow(Long max, Integer offset) {
		//获取当前用户
		Long userId = UserHolder.getUser().getId();
		//查询收件箱
		String key = FEED_KEY + userId;
		//如果是第一次查询 offset=0
		offset = offset == null ? 0 : offset;
		//返回score在[min, max]区间的逆序集合，3表示查询3条数据
		//此处的max：当前查询的最大值，上次查询的最小值
		Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet().
				reverseRangeByScoreWithScores(key, 0, max, offset, 3);
		//非空判断
		if(typedTuples == null || typedTuples.isEmpty()) {
			return Result.ok();
		}
		//解析数据：blogId、score(时间戳)、offset(上次查询中，与最小值相等的元素的个数)
		List<Long> ids = new ArrayList<>();
		long minTime = 0;
		int offsets = 1;
		for(ZSetOperations.TypedTuple<String> tuple : typedTuples) {
			ids.add(Long.valueOf(tuple.getValue()));//userId
			long timeStamp = tuple.getScore().longValue();
			if(timeStamp == minTime) {//是最小时间
				offsets++;
			} else {//不是最小时间
				minTime = timeStamp;//说明当前timeStamp是最小时间
				offsets = 1;//重置计数器
			}
		}
		//根据id查询Blog，封装并返回
		String idStr = StrUtil.join(",", ids);
		List<Blog> blogs = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();
		for(Blog blog : blogs) {
			//查询blog有关的用户
			queryBlogUser(blog);
			//查询blog是否被点赞
			isBlogLiked(blog);
		}

		ScrollResult scrollResult = new ScrollResult();
		scrollResult.setList(blogs);
		scrollResult.setOffset(offsets);
		scrollResult.setMinTime(minTime);
		return Result.ok(scrollResult);
	}
}
