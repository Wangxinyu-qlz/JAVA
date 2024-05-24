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
 * @create: 2024-05-24 09:33
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
	public void testAdd() {
		Monster monster = new Monster();
		monster.setAge(18);
		monster.setEmail("tn@sohu.com");
		monster.setGender(1);
		monster.setName("松鼠精");
		monster.setSalary(923.3);
		monsterMapper.addMonster(monster);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDel(){
		monsterMapper.delMonster(15);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		Monster monster = new Monster();
		monster.setId(14);
		monster.setName("9527");
		monster.setAge(18);
		monster.setEmail("123123123sohu.com");
		monster.setGender(0);
		monster.setSalary(9578.3);
		monster.setBirthday(new Date());
		monsterMapper.updateMonster(monster);

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("update success");
	}

	@Test
	public void testSelect() {
		Monster monster = monsterMapper.selectMonster(14);
		System.out.println(monster);
	}

	@Test
	public void testGetAllMonsters() {
		List<Monster> allMonsters = monsterMapper.getAllMonsters();
		for(Monster monster : allMonsters) {
			System.out.println(monster);
		}
	}

}
