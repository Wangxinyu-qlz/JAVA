package com.qlz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qlz.fmmall.dao")
//TODO 启动类所在的包名，必须包含beans mapper UserService common
// com.qlz com.qlz.fmmall 均可 但是com.qlz.api不可以
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
