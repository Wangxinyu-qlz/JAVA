import entity.Monster;
import mapper.MonsterMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-27 16:56
 * @description:
 **/
public class MonsterMapperTest {
	private SqlSession sqlSession;
	private MonsterMapper monsterMapper;

	@Before
	public void init() {
		sqlSession = MybatisUtils.getSqlSession();
		monsterMapper = sqlSession.getMapper(MonsterMapper.class);
	}

	@Test
	public void testInsert() {
		Monster monster = new Monster();
		monster.setAge(2023);
		monster.setBirthday(new Date());
		monster.setEmail("hjk");
		monster.setGender(2);
		monster.setName("qqqqqqqqqqq");
		monster.setSalary(9.3);

		monsterMapper.insert(monster);

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("success");
	}

	//查询满足id 或者 name 的所有对象
	@Test
	public void testSelectByNameOrId() {
		Monster monster = new Monster();
		monster.setId(18);
		monster.setName("牛魔王");
		List<Monster> monsters= monsterMapper.findMonsterByNameOrId(monster);
		for(Monster m : monsters) {
			System.out.println(m);
		}

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}

	//模糊查询
	@Test
	public void testSelectByValueInName() {
		String name = "牛";
		List<Monster> monsters = monsterMapper.findMonsterByName(name);
		for(Monster m : monsters) {
			System.out.println(m);
		}
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

		System.out.println("ok");
	}

	@Test
	public void testSelectMonsterByIdAndSalary() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 15);
		map.put("salary", 9.0);
		List<Monster> monsters = monsterMapper.findMonsterByIdAndSalary(map);
		for(Monster m : monsters) {
			System.out.println(m);
		}
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}

	@Test
	public void testFindMonsterByIdAndSalary_returnMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 15);
		map.put("salary", 9.0);
		List<Map<String, Object>> monster = monsterMapper.findMonsterByIdAndSalary_returnMap(map);
		for(Map<String, Object> m : monster) {
			System.out.println(m);
		}
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}
}
