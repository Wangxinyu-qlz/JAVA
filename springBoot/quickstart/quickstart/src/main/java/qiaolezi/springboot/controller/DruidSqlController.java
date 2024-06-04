package qiaolezi.springboot.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiaolezi.springboot.bean.Furn2;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 21:46
 * @description:
 **/
@Controller
public class DruidSqlController {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@ResponseBody
	@GetMapping("/sql")
	public List<Furn2> crudDB() {
		BeanPropertyRowMapper<Furn2> rowMapper = new BeanPropertyRowMapper<>(Furn2.class);
		String sql = "select * from furn";
		List<Furn2> furn2List = jdbcTemplate.query(sql, rowMapper);
		for(Furn2 furn2 : furn2List){
			System.out.println(furn2);
		}
		return furn2List;
	}
}
