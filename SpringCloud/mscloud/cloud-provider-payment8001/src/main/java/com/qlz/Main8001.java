package com.qlz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.qlz.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class Main8001
{
    public static void main( String[] args )
    {
        SpringApplication.run(Main8001.class, args);
    }
}
