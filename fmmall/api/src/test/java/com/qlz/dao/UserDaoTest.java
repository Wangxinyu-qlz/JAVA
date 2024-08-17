package com.qlz.dao;
import com.qlz.ApiApplication;
import com.qlz.fmmall.dao.UserDao;
import com.qlz.fmmall.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class UserDaoTest {
	@Resource
	private UserDao userDao;
	@Test
	public void testSelect() {
		User qlz = userDao.queryByName("qlz");
		System.out.println(qlz.toString());
	}
}