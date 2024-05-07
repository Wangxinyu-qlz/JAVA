package mapper;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 17:40
 * @description:
 **/
public class UserMapperAnnotationTest {
	private SqlSession sqlSession;
	private UserMapperAnnotation userMapperAnnotation;
	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		userMapperAnnotation = sqlSession.getMapper(UserMapperAnnotation.class);
	}

	@Test
	public void test1() {
		System.out.println("OK");
	}

	@Test
	public void test2() {
		User user = userMapperAnnotation.getUserById(1);

		System.out.println(user.getName());

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK");
	}
}
