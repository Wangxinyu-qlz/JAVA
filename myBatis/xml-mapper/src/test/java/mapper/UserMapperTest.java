package mapper;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-02 15:56
 * @description:
 **/
public class UserMapperTest {
	private SqlSession sqlSession;
	private UserMapper userMapper;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	@Test
	public void add() {
		User user = new User();
		user.setUseremail("test@gmail.com");
		user.setUsername("teset");

		userMapper.addUser(user);

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

		System.out.println("添加成功！");
	}

	@Test
	public void getAllUser() {
		List<User> users = userMapper.getAllUser();
		for(User user : users) {
			System.out.println("user==" + user);
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询成功！");
	}
}
