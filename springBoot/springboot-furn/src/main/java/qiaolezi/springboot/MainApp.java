package qiaolezi.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:20
 * @description:
 **/
@MapperScan("qiaolezi.springboot.mapper")
@SpringBootApplication
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
