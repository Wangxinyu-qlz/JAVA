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

	//在执行目标测试方法前执行
	@Before
	public void init() {
		//获取会话
		sqlSession = MyBatisUtils.getSqlSession();
		//获取MonsterMapper对象
		monsterMapper = sqlSession.getMapper(MonsterMapper.class);
		//monsterMapper = class com.sun.proxy.$Proxy7
		System.out.println("monsterMapper = " + monsterMapper.getClass());
	}

	@Test
	public void test1() {
		System.out.println("test()......");
	}

	//添加
	@Test
	public void addMonster() {
		for (int i = 0; i < 2; i++) {
			Monster monster = new Monster();
			monster.setAge(10 + i);
			monster.setBirthday(new Date());
			monster.setEmail("airuh@qq.com");
			monster.setGender(1);
			monster.setName("强");
			monster.setSalary(1111.0);
			monsterMapper.addMonster(monster);
			System.out.println("成功添加对象--" + monster);

			System.out.println("添加到表中后，id = " + monster.getId());
		}

		//TODO 如果增删改，需要提交事务 否则不会生效
		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

		System.out.println("保存成功！");
	}

	//删除
	@Test
	public void deleteMonster() {
		monsterMapper.deleteMonster(3);
		//如果增删改，需要提交事务
		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("删除成功---");
	}


	//修改
	@Test
	public void updateMonster() {
		//Created connection 210506412.
		//Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@c8c12ac]
		Monster monster = new Monster();
		monster.setAge(110);
		monster.setBirthday(new Date());
		monster.setEmail("airuh@qq.com");
		monster.setGender(0);
		monster.setName("0000000000000");
		monster.setSalary(1111.0);
		monster.setId(5);
		monsterMapper.updateMonster(monster);
		//如果增删改，需要提交事务
		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();//Returned connection 210506412 to pool.
		}
		System.out.println("修改成功---");
	}

	//查询
	@Test
	public void selectMonster() {
		Monster monster = monsterMapper.getMonsterById(5);
		System.out.println("查询成功---");
		System.out.println(monster);
	}

	//查询
	@Test
	public void selectAllMonsters() {
		List<Monster> allMonsters = monsterMapper.getAllMonsters();
		System.out.println("查询成功---");
		for(Monster monster : allMonsters) {
			System.out.println(monster);
		}
	}
}
