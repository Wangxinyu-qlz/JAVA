package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtils;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 09:33
 * @description:
 **/
public class MonsterMapperTest {
	@Test
	public void test() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		MonsterMapper mapper = sqlSession.getMapper(MonsterMapper.class);
		Monster monster = new Monster();
		monster.setName("11111");
		monster.setAge(18);
		monster.setEmail("tn@sohu.com");
		monster.setGender(1);
		monster.setName("松鼠精");
		monster.setSalary(923.3);
		mapper.addMonster(monster);

		sqlSession.commit();
		sqlSession.close();

	}
}
