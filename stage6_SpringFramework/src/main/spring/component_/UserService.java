package main.spring.component_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 11:50
 * @description:
 **/
@Service
public class UserService {
	//Spring容器如何实现依赖注入
	//@Autowired
	@Resource
	private UserDao userDao;

	public void m1() {
		userDao.hi();
	}

	@PostConstruct  //指定为初始化方法
	public void init() {
		System.out.println("UserService init()");
	}
}
