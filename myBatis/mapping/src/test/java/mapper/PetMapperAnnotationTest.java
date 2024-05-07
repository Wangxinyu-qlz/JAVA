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
 * @create: 2024-05-07 18:10
 * @description:
 **/
public class PetMapperAnnotationTest {
	private SqlSession sqlSession;
	private PetMapperAnnotation petMapperAnnotation;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		petMapperAnnotation = sqlSession.getMapper(PetMapperAnnotation.class);
	}

	@Test
	public void test() {
		System.out.println("OK");
	}

	@Test
	public void test1() {
		Pet pet = petMapperAnnotation.getPetById(1);
		System.out.println("petById: " + pet.getNickname());
		User user = pet.getUser();
		System.out.println("user: " + user.getName());
	}

	@Test
	public void test2() {
		List<Pet> pets = petMapperAnnotation.getPetsByUserId(2);
		for (Pet pet : pets) {
			System.out.println("pet: " + pet.getNickname());
		}
	}
}
