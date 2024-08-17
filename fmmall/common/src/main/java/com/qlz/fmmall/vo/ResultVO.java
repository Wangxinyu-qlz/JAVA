package com.qlz.fmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-16 20:49
 * @description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
	//响应给前端的状态码
	private int code;
	//响应给前端的提示信息
	private String msg;
	//响应给前端的数据
	private Object data;
}
