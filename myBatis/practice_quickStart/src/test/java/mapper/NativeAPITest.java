package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

import java.util.Date;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 11:08
 * @description:
 **/
public class NativeAPITest {
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
		monster.setAge(2023);
		monster.setBirthday(new Date());
		monster.setEmail("hjk");
		monster.setGender(2);
		monster.setName("白");
		monster.setSalary(9.3);
		sqlSession.insert("mapper.MonsterMapper.addMonster", monster);

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

		System.out.println("ok");
	}

	@Test
	public void testDel() {
		sqlSession.delete("mapper.MonsterMapper.delMonster", 16);
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("del ok");
	}

	@Test
	public void testUpdate() {
		Monster monster = new Monster();
		monster.setAge(2023);
		monster.setBirthday(new Date());
		monster.setEmail("hjk");
		monster.setGender(2);
		monster.setName("白");
		monster.setSalary(9.3);
		monster.setId(14);

		sqlSession.update("mapper.MonsterMapper.updateMonster", monster);
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}


}
