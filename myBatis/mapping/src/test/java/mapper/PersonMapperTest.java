package mapper;

import entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-05 21:41
 * @description:
 **/
public class PersonMapperTest {
	private SqlSession sqlSession;
	private PersonMapper personMapper;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		personMapper = sqlSession.getMapper(PersonMapper.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	@Test
	public void getIdenCardByCardId() {
		Person personById = personMapper.getPersonById(1);
		System.out.println("personById:" + personById);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("ok");
	}

	@Test
	public void getIdenCardByCardId2() {
		Person personById = personMapper.getPersonById2(1);
		System.out.println("personById:" + personById);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("ok");
	}
}
