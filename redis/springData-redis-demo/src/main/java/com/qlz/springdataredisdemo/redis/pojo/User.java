package com.qlz.springdataredisdemo.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springData-redis-demo
 * @author: Qiaolezi
 * @create: 2024-06-21 15:49
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String name;
	private Integer age;
}
