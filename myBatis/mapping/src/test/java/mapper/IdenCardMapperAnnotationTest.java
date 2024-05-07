package mapper;

import entity.IdenCard;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.sql.Time;
import java.util.Date;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 15:50
 * @description:
 **/
public class IdenCardMapperAnnotationTest {
	private SqlSession sqlSession;
	private IdenCardMapperAnnotation cardMapperAnnotation;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		cardMapperAnnotation = sqlSession.getMapper(IdenCardMapperAnnotation.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		IdenCard idenCardById = cardMapperAnnotation.getIdenCardById(1);
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - start) + "ms");
		System.out.println("idenCardById=" + idenCardById);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("OK!");
	}
}
