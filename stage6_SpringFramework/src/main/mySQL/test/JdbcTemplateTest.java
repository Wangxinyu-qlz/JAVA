package main.mySQL.test;

import main.mySQL.dao.MonsterDao;
import main.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 21:41
 * @description:
 **/
public class JdbcTemplateTest {
	@Test
	public void testDatasourceByJdbcTemplate() throws SQLException {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println("获取到connection=" + connection);
		connection.close();

		System.out.println("OK!");
	}

	//通过jdbcTemplate独享完成添加数据
	@Test
	public void addDataByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		//1.添加方式1
		//String sql = "INSERT INTO monster VALUES(400, '白象精', 'ttt');";
		//jdbcTemplate.update(sql);
		//2.添加方式2  ?占位
		String sql = "INSERT INTO monster VALUES(?, ?, ?);";
		//表示执行后，受影响的结果数量
		int affected = jdbcTemplate.update(sql, 500, "红孩儿", "吐火");
		System.out.println("add ok affected=" + affected);//1
	}

	@Test
	public void updateDataByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		String sql = "UPDATE monster SET skill=? WHERE id=?";
		//TODO 不管原来是什么，只要执行成功，就会返回1（不会判断内容是否改变）
		int affected = jdbcTemplate.update(sql, "三头六臂", 500);
		System.out.println("update ok affected=" + affected);
	}

	@Test
	public void addBatchDataByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		String sql = "INSERT INTO monster VALUES(?, ?, ?);";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{600, "老鼠精", "→"});
		batchArgs.add(new Object[]{700, "老猫精", "↑"});
		//int[] batchUpdate(String sql, List<Object[]> batchArgs)
		int[] affected = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int anInt : affected) {
			System.out.println("anInt=" + anInt);
		}
		System.out.println("批量添加成功！");
	}

	//查询对象之后，封装为一个对象
	@Test
	public void selectDataByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		//TODO 这里查出来的id要和Monster类的属性保持一致，做一个转换，否则获取到的对象的id=null
		String sql = "SELECT id AS monsterId, name, skill FROM monster WHERE id = 100";
		//TODO 对返回的数据进行封装->底层使用反射--setter()
		// BeanPropertyRowMapper 构造器需要一个Monster.class
		BeanPropertyRowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);

		//<T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
		Monster monster = jdbcTemplate.queryForObject(sql, rowMapper);
		System.out.println("monster=" + monster);
	}

	//查询 id>=200 的对象之后，封装为一个对象列表
	@Test
	public void selectMultiDataByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		String sql = "SELECT id AS monsterId, name, skill FROM monster WHERE id >= ?";
		BeanPropertyRowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);

		//<T> T query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
		List<Monster> monsterList = jdbcTemplate.query(sql, rowMapper, 200);
		for (Monster monster : monsterList) {
			System.out.println("monster=" + monster);
		}
	}

	//查询一行一列的值（一个单元格的值）
	@Test
	public void selectScalarByJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
		JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

		String sql = "SELECT NAME FROM monster WHERE id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, 200);
		System.out.println("name=" + name);
	}

	//使用Map传入具名参数完成操作，如添加 螃蟹精.:name
	@Test
	public void testDataByNamedParameterJdbcTemplate() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate =
				ioc.getBean(NamedParameterJdbcTemplate.class);

		//[:my_id, :name, :skill]按照规定的名字设置参数 TODO 这里的参数名字应该和数据库中的字段名一致
		String sql = "INSERT INTO monster VALUES(:id, :name, :skill)";
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("id", 800);
		paraMap.put("name", "蚂蚁精");
		paraMap.put("skill", "打洞");
		//int update(String sql, Map<String, ?> paramMap) throws DataAccessException;
		int affected = namedParameterJdbcTemplate.update(sql, paraMap);
		System.out.println("add ok affected=" + affected);
	}

	//使用sqlParameterSource 封装具名参数，添加一条记录
	@Test
	public void operateDataBySqlParameterSource() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate =
				ioc.getBean(NamedParameterJdbcTemplate.class);

		//[:my_id, :name, :skill]按照规定的名字设置参数 TODO 这里的参数名字应该和Monster属性名保持一致
		String sql = "INSERT INTO monster VALUES(:monsterId, :name, :skill)";
		Monster monster = new Monster(900, "土地爷", "导航");
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(monster);

		//int update(String sql, SqlParameterSource paramSource)
		int affected = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		System.out.println("update ok affected=" + affected);
	}

	//测试MonsterDao::save()方法
	@Test
	public void testMonsterDao() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbcTemplate_ioc.xml");

		MonsterDao monsterDao = ioc.getBean(MonsterDao.class);
		Monster monster = new Monster(1000, "白骨精", "变身");
		monsterDao.save(monster);
	}
}
