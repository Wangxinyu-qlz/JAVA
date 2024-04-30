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
 * @create: 2024-04-30 18:04
 * @description: 使用 MyBatis 原生 API 操作数据库
 **/
public class MyBatisNativeAPITest {
	private SqlSession sqlSession;

	@Before
	public void init() {
		sqlSession = MyBatisUtils.getSqlSession();
		//sqlSession返回的对象是 DefaultSqlSession
		//org.apache.ibatis.session.defaults.DefaultSqlSession
		System.out.println("sqlSession: " + sqlSession.getClass());
	}

	@Test
	public void nativeInsert() {
		Monster monster = new Monster();
		monster.setAge(10);
		monster.setBirthday(new Date());
		monster.setEmail("q4234we@qq.com");
		monster.setGender(1);
		monster.setName("黑希铠甲");
		monster.setSalary(111100.0);

		int insert = sqlSession.insert("mapper.MonsterMapper.addMonster", monster);
		System.out.println("insert: " + insert);


		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	@Test
	public void nativeDelete() {
		int delete = sqlSession.delete("mapper.MonsterMapper.deleteMonster", 4);
		System.out.println("delete: " + delete);

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	//修改
	@Test
	public void nativeUpdate() {
		Monster monster = new Monster();
		monster.setAge(33);
		monster.setBirthday(new Date());
		monster.setEmail("123sergsrg@qq.com");
		monster.setGender(1);
		monster.setName("糯米");
		monster.setSalary(1345600.0);
		monster.setId(5);//TODO 这里要设置一个id 否则不知道改哪一个
		int update = sqlSession.update("mapper.MonsterMapper.updateMonster", monster);
		System.out.println("update: " + update);

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("修改成功！");
	}

	//查找
	@Test
	public void nativeSelect() {
		Monster monstera = sqlSession.selectOne("mapper.MonsterMapper.getMonsterById", 5);
		System.out.println("monster: " + monstera);
		System.out.println("=======================");

		List<Monster> monsters = sqlSession.selectList("mapper.MonsterMapper.getAllMonsters");
		for(Monster monster : monsters) {
			System.out.println(monster);
		}
		System.out.println("==================");

	}
}
