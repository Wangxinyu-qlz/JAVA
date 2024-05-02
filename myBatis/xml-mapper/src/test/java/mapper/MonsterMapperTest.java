package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-04-30 16:47
 * @description:
 **/
public class MonsterMapperTest {
	private SqlSession sqlSession;
	private MonsterMapper monsterMapper;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		monsterMapper = sqlSession.getMapper(MonsterMapper.class);
	}

	@Test
	public void test1() {
		System.out.println("ok");
	}

	//多条件查询
	@Test
	public void getMonsterByNameORId() {
		Monster monster = new Monster();
		monster.setId(11);
		monster.setName("大象精");
		List<Monster> monsters = monsterMapper.getMonsterByNameORId(monster);
		for(Monster m : monsters) {
			System.out.println("monster:" + m);
		}

		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	//模糊查询
	@Test
	public void getMonsterByName() {
		List<Monster> monsters = monsterMapper.getMonsterByName("精");
		for(Monster m : monsters) {
			System.out.println("monster:" + m);
		}

		if(sqlSession != null) {
			sqlSession.close();
		}
	}
}
