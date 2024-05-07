package mapper;

import entity.Pet;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:49
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
		System.out.println("OK");
	}

	@Test
	public void test2() {
		User user = userMapper.getUserById(1);
		System.out.println("user：" + user.getId() + "-" + user.getName() + "-宠物信息：");
		List<Pet> pets = user.getPets();
		for(Pet pet : pets) {
			System.out.println("\t\tpet=" + pet.getId() + "-" + pet.getNickname());
		}

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK~");
	}

}
