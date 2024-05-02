package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	@Test
	public void getMonsterByIdAndSalary_ParameterHashMap() {
		Map<String , Object> map = new HashMap<>();
		map.put("id", 10);
		map.put("salary", 40);
		List<Monster> monster = monsterMapper.getMonsterByIdAndSalary_ParameterHashMap(map);
		for(Monster m : monster) {
			System.out.println("monster:" + m);
		}

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询成功！");
	}

	@Test
	public void getMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap() {
		Map<String , Object> map = new HashMap<>();
		map.put("id", 10);
		map.put("salary", 40);
		List<Map<String, Object>> monsterMaps = monsterMapper.getMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap(map);
		for(Map<String, Object> monsterMap : monsterMaps) {
			//System.out.println("monsterMap:" + monsterMap);
			//遍历monsterMap
			//Set<String> keys = monsterMap.keySet();
			//for(String key : keys) {
			//	System.out.println(key + ":" + monsterMap.get(key));
			//}

			for(Map.Entry<String, Object> entry : monsterMap.entrySet()) {
				System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
			}
			System.out.println("====================================");
		}

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("查询成功！");
	}

}
