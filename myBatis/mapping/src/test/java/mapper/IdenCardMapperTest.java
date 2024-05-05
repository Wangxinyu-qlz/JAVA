package mapper;

import entity.IdenCard;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-05 21:32
 * @description:
 **/
public class IdenCardMapperTest {

	private SqlSession sqlSession;
	private IdenCardMapper idenCardMapper;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		idenCardMapper = sqlSession.getMapper(IdenCardMapper.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	@Test
	public void getIdenCardByCardId() {
		IdenCard idenCardById = idenCardMapper.getIdenCardById(1);
		System.out.println("idenCardById:" + idenCardById);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("ok");
	}

}
