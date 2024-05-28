import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtils;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-28 09:46
 * @description:
 **/
public class TestUserMapper {
	private SqlSession sqlSession;
	private UserMapper userMapper;

	@Before
	public void init() {
		sqlSession = MybatisUtils.getSqlSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setUseremail("23.22.com");
		user.setUsername("三儿");
		userMapper.addUser(user);

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = userMapper.findAllUsers();
		for(User user : users) {
			System.out.println(user);
		}

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}
}
