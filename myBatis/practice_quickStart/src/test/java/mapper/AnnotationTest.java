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
 * @create: 2024-05-24 11:47
 * @description:
 **/
public class AnnotationTest {
	private SqlSession sqlSession;
	private MonsterAnnotation monsterAnnotation;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);
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
		monsterAnnotation.addMonster(monster);

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}

	@Test
	public void testDel() {
		monsterAnnotation.delMonster(17);
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

		System.out.println("ok");
	}

	public void testUpdate() {
		Monster monster = new Monster();
		monster.setAge(2023);
		monster.setBirthday(new Date());
		monster.setEmail("hjk");
		monster.setGender(2);
		monster.setName("白");
		monster.setSalary(9.3);
		monster.setId(60);
		monsterAnnotation.updateMonster(monster);
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("ok");
	}

	@Test
	public void testSelect() {
		Monster monster = monsterAnnotation.getMonsterById(6);
		System.out.println(monster);

		if(sqlSession != null) {
			sqlSession.close();
		}

		System.out.println("ok");
	}
}
