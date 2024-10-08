package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 14:44
 * @description:
 **/
@Mapper
public interface UserMapper {
	/**
	 * 根据openid查询用户
	 * @param openid
	 * @return
	 */
	@Select("select * from user where openid = #{openid}")
	User getByOpenid(String openid);

	/**
	 * 插入用户数据
	 * @param user
	 */
	void insert(User user);

	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	User getById(Long userId);

	/**
	 * 动态查询 时间区间内的用户数量
	 * @param totalUserMap
	 * @return
	 */
	Integer countByMap(Map totalUserMap);
}
