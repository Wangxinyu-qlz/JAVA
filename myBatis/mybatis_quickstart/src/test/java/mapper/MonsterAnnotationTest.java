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
 * @create: 2024-04-30 18:51
 * @description:
 **/
public class MonsterAnnotationTest {
	private SqlSession sqlSession;
	private MonsterAnnotation monsterAnnotation;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);
		System.out.println("monsterAnnotation:  " + monsterAnnotation);
	}

	@Test
	public void add() {
		Monster monster = new Monster();
		monster.setAge(5454);
		monster.setBirthday(new Date());
		monster.setEmail("123啊我俄日挺好@qq.com");
		monster.setGender(1);
		monster.setName("强");
		monster.setSalary(10.212121);
		monsterAnnotation.addMonster(monster);
		System.out.println("成功添加对象--" + monster);

		System.out.println("添加到表中后，id = " + monster.getId());

		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("添加成功！");
	}
}
