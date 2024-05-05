package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
		System.out.println("test()......");
	}


	@Test
	public void selectAllMonsterIf() {
		List<Monster> monsters = monsterMapper.getMonsterByAge(100);
		for (Monster monster : monsters) {
			System.out.println("monster=" + monster);
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询完毕~");
	}


	@Test
	public void selectAllMonsterIfWhere() {
		Monster monster = new Monster();
		monster.setId(1);
		//monster.setName("牛魔王");
		List<Monster> monsters = monsterMapper.getMonsterByIdAndName(monster);

		for (Monster m : monsters) {
			System.out.println("m=" + m);
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询完毕~");
	}


	@Test
	public void getMonsterByIdOrName_choose() {
		Map<String, Object> map = new HashMap<>();
		//map.put("name", "牛魔王");
		map.put("id", 10);
		List<Monster> monsters = monsterMapper.getMonsterByIdOrName_choose(map);

		for (Monster m : monsters) {
			System.out.println("m=" + m);
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询完毕~");
	}

	@Test
	public void getMonsterById_forEach() {
		Map<String, Object> map = new HashMap<>();
		map.put("ids", Arrays.asList(11, 12));
		System.out.println(map.get("ids"));

		List<Monster> monsters = monsterMapper.getMonsterById_forEach(map);
		for (Monster m : monsters) {
			System.out.println("m=" + m);
		}

		if (sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询完毕~");
	}
}
