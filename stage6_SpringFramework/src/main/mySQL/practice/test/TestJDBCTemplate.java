package main.mySQL.practice.test;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import main.spring.bean.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-21 15:51
 * @description:
 **/
public class TestJDBCTemplate {
	private ApplicationContext ioc;
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testJDBCConnection() throws SQLException {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc_config.xml");
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		//com.mchange.v2.c3p0.impl.NewProxyConnection@156b88f5
		// [wrapping: com.mysql.cj.jdbc.ConnectionImpl@3bf9ce3e]
		System.out.println(connection);
		connection.close();
	}

	@BeforeEach
	public void init() {
		ioc = new ClassPathXmlApplicationContext("jdbc_config.xml");
		jdbcTemplate = ioc.getBean(JdbcTemplate.class);
	}

	//添加public int update(String sql, @Nullable Object... args)
	@Test
	public void addDataByJDBCTemplate() throws SQLException {
		String sql = "insert into monster values(?, ?, ?)";
		int affected = jdbcTemplate.update(sql, 23, "红孩儿", "三头");
		System.out.println(affected);
	}

	//更改 public int update(String sql, @Nullable Object... args)
	@Test
	public void updateDataByJDBCTemplate() throws SQLException {
		String sql = "update monster set skill = ? where id = ?";
		int affected = jdbcTemplate.update(sql, "花枪", 23);
		System.out.println(affected);
	}

	//批量添加  public int[] batchUpdate(String sql, java.util.List<Object[]> batchArgs)
	@Test
	public void addBatchDataByJDBCTemplate() throws SQLException {
		String sql = "insert into monster values(?, ?, ?)";
		//Object[] 数组存放各个字段
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{511, "摆设", "1"});
		list.add(new Object[]{512, "wer", "12"});
		int[] affected = jdbcTemplate.batchUpdate(sql, list);
		for(int i:affected){
			System.out.println(i);
		}
	}

	@Test
	public void addBatchBy() {
		String sql = "insert into monster values(?, ?, ?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{11, "longrne", "toawie"});
		list.add(new Object[] {12, "12", "12"});
		int[] affected = jdbcTemplate.batchUpdate(sql, list);
		for(int i:affected) {
			System.out.println(i);
		}
	}

	// 查询并封装到实体对象
	// public <T> T queryForObject
	// (String sql, org.springframework.jdbc.core.RowMapper<T> rowMapper,
	// @Nullable Object... args)
	@Test
	public void selectDataByJDBCTemplate() throws SQLException {
		String sql = "select id as monsterId, name, skill from monster where id = ?";
		BeanPropertyRowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
		Monster monster = jdbcTemplate.queryForObject(sql, rowMapper, 100);
		System.out.println(monster);
	}

	@Test
	public void selectDataBy() {
		String sql = "select id as monsterId, name, skill from monster where id = ?";
		BeanPropertyRowMapper<Monster> mapper = new BeanPropertyRowMapper<>(Monster.class);
		//org.springframework.jdbc.core.BeanPropertyRowMapper@63376bed
		System.out.println(mapper);
		Monster monster = jdbcTemplate.queryForObject(sql, mapper, 200);
		System.out.println("monster:" + monster);
	}

	//批量查询并封装到实体对象
	//public <T> java. util. List<T> query
	// (String sql, org.springframework.jdbc.core.RowMapper<T> rowMapper,
	// @Nullable Object... args)
	@Test
	public void selectMultiDataByJDBCTemplate() throws SQLException {
		String sql = "select id as monsterId, name, skill from monster where id > ?";
		BeanPropertyRowMapper<Monster> monsterBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Monster.class);
		System.out.println(monsterBeanPropertyRowMapper);
		List<Monster> monsters = jdbcTemplate.query(sql, monsterBeanPropertyRowMapper, 200);
		for(Monster monster: monsters) {
			System.out.println(monster);
		}
	}

	//查询返回结果只有一行一列的值，查询id=?的名字
	//public <T> T queryForObject
	// (String sql, Class<T> requiredType, @Nullable Object... args)
	@Test
	public void selectScalarByJdbcTemplate() {
		String sql = "select name from monster where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, 100);
		System.out.println(name);

		String sql1 = "select id from monster where id = ?";
		//这里写成String也可以
		String id = jdbcTemplate.queryForObject(sql1, String.class, 100);
		System.out.println(id);
	}

	//使用 Map 传入具名参数完成操作，比如添加 螃蟹精.:name 就是具名参数形式
	//需要使用 NamedParameterJdbcTemplate 类
	//public int update(String sql, java.util.Map<String,?> paramMap)
	@Test
	public void testDataByNamedParameterJdbcTemplate() {
		//TODO 这里需要使用 NamedParameterJdbcTemplate.class
		NamedParameterJdbcTemplate bean = ioc.getBean(NamedParameterJdbcTemplate.class);
		String sql = "insert into monster values(:my_id, :name, :skill)";
		Map<String, Object> stringObjectHashMap = new HashMap<>();
		stringObjectHashMap.put("my_id", 667);
		stringObjectHashMap.put("name", "12");
		stringObjectHashMap.put("skill", "sd");
		bean.update(sql, stringObjectHashMap);
		System.out.println("OK~");
	}

	@Test
	public void insertByNamedParameters() {
		NamedParameterJdbcTemplate bean = ioc.getBean(NamedParameterJdbcTemplate.class);
		String sql = "insert into monster values(:idd, :named, :skilllll)";
		HashMap<String, Object> map = new HashMap<>();
		map.put("idd", 668);
		map.put("named", "wer");
		map.put("skilllll", "shaohuogun");
		int update = bean.update(sql, map);
		System.out.println(update);
	}

	//使用 sqlParameterSource 来封装具名参数,还是添加一个 Monster 狐狸精
	//public int update(String sql,
	// org.springframework.jdbc.core.namedparam.SqlParameterSource paramSource )
	@Test
	public void operatorDataBySqlParameterSource() {
		//TODO 这里需要使用 NamedParameterJdbcTemplate.class
		NamedParameterJdbcTemplate bean = ioc.getBean(NamedParameterJdbcTemplate.class);
		String sql = "insert into monster values(:monsterId, :name, :skill)";
		Monster monster = new Monster(901, "护理", "优雅");
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(monster);
		int update = bean.update(sql, source);
		System.out.println(update);
	}

	@Test
	public void operatorDataBySqParameterSource2() {
		NamedParameterJdbcTemplate bean = ioc.getBean(NamedParameterJdbcTemplate.class);
		String sql = "insert into monster values(:monsterId, :name, :skill)";
		Monster monster = new Monster(902, "werr", "ty");
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(monster);
		int affected = bean.update(sql, source);
		System.out.println(affected);
	}
}
