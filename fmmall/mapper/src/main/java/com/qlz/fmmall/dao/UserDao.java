package com.qlz.fmmall.dao;

import com.qlz.fmmall.entity.User;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 17:59
 * @description:
 **/
public interface UserDao {
	public User queryByName(String name);
}
