package com.qlz.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 17:57
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer userId;
	private String userName;
	private String userPwd;
	private String userRealname;
	private String userImg;
}
