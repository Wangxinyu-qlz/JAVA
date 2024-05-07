package mapper;

import entity.Monster;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import util.MyBatisUtils;

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
		sqlSession = MyBatisUtils.getSqlSession();
		monsterMapper = sqlSession.getMapper(MonsterMapper.class);
	}

	//查询
	@Test
	public void selectMonster() {
		Monster monster = monsterMapper.getMonsterById(5);
		System.out.println("查询成功---");
		System.out.println(monster);

		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	//测试一级缓存
	//一级缓存失效：
	//1.关闭会话 sqlSession.close();
	//2.手动清空缓存 sqlSession.clearCache();
	//3.对同一个对象进行修改，该对象在一级缓存会失效
	@Test
	public void level1CacheTest() {
		Monster monster = monsterMapper.getMonsterById(5);
		System.out.println(monster);

		sqlSession.clearCache();
		System.out.println("======一级缓存默认打开，重复查询相同id时，不会再发出sql语句");
		Monster monster2 = monsterMapper.getMonsterById(5);
		System.out.println(monster2);

		if (sqlSession != null) {
			sqlSession.close();
		}
	}


	//测试二级缓存
	@Test
	public void level2CacheTest() {
		Monster monster = monsterMapper.getMonsterById(5);
		System.out.println(monster);

		if (sqlSession != null) {
			sqlSession.close();
		}
		init();
		System.out.println("开启了二级缓存，在关闭会话之后，" +
				"再次查询相同的对象，不会发出sql，直接从二级缓存获取数据");
		//Cache Hit Ratio [mapper.MonsterMapper]: 0.5
		//这里一共对id=5的monster进行了两次查询，第一次没有找到缓存，第二次找到了，所有命中率是0.5
		Monster monster2 = monsterMapper.getMonsterById(5);
		System.out.println(monster2);

		if (sqlSession != null) {
			sqlSession.close();
		}
	}


	//测试一级/二级缓存 执行顺序：二级->一级->DB
	@Test
	public void cacheSeqTest() {
		System.out.println("==================第一次查询=======================");
		Monster monster = monsterMapper.getMonsterById(5);
		System.out.println(monster);

		//当关闭会话时，一级缓存会清空
		//TODO 当关闭一级缓存时，或者sqlSession提交时，如果配置了二级缓存，一级缓存的数据放入到二级缓存
		// 如果不提交，数据不会放进二级缓存
		//Cache Hit Ratio [mapper.MonsterMapper]: 0.0
		if (sqlSession != null) {
			sqlSession.close();
		}
		init();
		sqlSession.commit();

		//从二级缓存获取
		System.out.println("=============第二次查询========================");
		//Cache Hit Ratio [mapper.MonsterMapper]: 0.5
		Monster monster2 = monsterMapper.getMonsterById(5);
		System.out.println(monster2);

		//从二级缓获取
		//Cache Hit Ratio [mapper.MonsterMapper]: 0.666666666666
		System.out.println("=============第三次查询========================");
		Monster monster3 = monsterMapper.getMonsterById(5);
		System.out.println(monster3);

		if (sqlSession != null) {
			sqlSession.close();
		}
	}


}
