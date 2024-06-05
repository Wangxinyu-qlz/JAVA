package test.qiaolezi.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import qiaolezi.springboot.MainApp;
import qiaolezi.springboot.bean.Furn;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:39
 * @description:
 **/
@SpringBootTest(classes = MainApp.class)
public class ApplicationTests {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		BeanPropertyRowMapper<Furn> rowMapper =
				new BeanPropertyRowMapper<>(Furn.class);
		String sql = "select * from furn";
		List<Furn> furns = jdbcTemplate.query(sql, rowMapper);
		for (Furn furn : furns) {
			System.out.println(furn);
		}
	}
}
