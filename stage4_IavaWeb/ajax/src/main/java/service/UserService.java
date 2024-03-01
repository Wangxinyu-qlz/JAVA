package service;

import ajax.entity.User;
import dao.UserDAO;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-01 11:04
 * @description: 提供业务方法
 **/
public class UserService {
	private UserDAO userDAO = new UserDAO();
	public User getUserByName(String username) {
		//TODO User.class底层是反射，new User()用的是无参构造器，必须在User中提供一个无参构造器
		// User类中有一个有参构造器，所以必须显式声明一个无参构造器
		User user = userDAO.querySingle
				("select * from `user` where username=?", User.class, username);
		return user;
	}
}
