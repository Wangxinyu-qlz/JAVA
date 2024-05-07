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
 * @create: 2024-05-07 17:23
 * @description:
 **/
public class PetMapperTest {
	private SqlSession sqlSession;
	private PetMapper petMapper;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		petMapper = sqlSession.getMapper(PetMapper.class);
	}

	@Test
	public void test1() {
		System.out.println("OK");
	}

	@Test
	public void test2() {
		List<Pet> pets = petMapper.getPetByUserId(1);

		for (Pet pet : pets) {
			System.out.println("pet:  " + pet.getId() + "-" + pet.getNickname());
			User user = pet.getUser();
			System.out.println("user信息：" + user.getName());
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK~");
	}


	@Test
	public void test3() {
		Pet pet = petMapper.getPetById(2);

		System.out.println("pet:  " + pet.getId() + "-" + pet.getNickname());
		User user = pet.getUser();
		System.out.println("user信息：" + user.getName());

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK~");
	}
}
