package mapper;

import entity.IdenCard;
import entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:16
 * @description:
 **/
public class PersonMapperAnnotationTest {
	private SqlSession sqlSession;
	private PersonMapperAnnotation personMapperAnnotation;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		Person personById = personMapperAnnotation.getPersonById(1);
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - start) + "ms");
		System.out.println("personById=" + personById);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK!");
	}
}
