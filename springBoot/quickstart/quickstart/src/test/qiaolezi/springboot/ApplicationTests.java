package test.qiaolezi.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import qiaolezi.springboot.MainApp;
import qiaolezi.springboot.bean.Furn;
import qiaolezi.springboot.bean.Furn2;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 20:26
 * @description:
 **/
@SpringBootTest(classes = MainApp.class)
public class ApplicationTests {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		BeanPropertyRowMapper<Furn2> rowMapper =
				new BeanPropertyRowMapper<>(Furn2.class);
		String sql = "select * from furn";
		List<Furn2> query = jdbcTemplate.query(sql, rowMapper);
		for (Furn2 furn : query) {
			System.out.println(furn);
		}

		//class com.zaxxer.hikari.HikariDataSource
		System.out.println(jdbcTemplate.getDataSource().getClass());
	}
}
