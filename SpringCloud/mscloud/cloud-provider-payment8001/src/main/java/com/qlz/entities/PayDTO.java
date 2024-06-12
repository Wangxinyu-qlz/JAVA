package com.qlz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: mscloud
 * @author: Qiaolezi
 * @create: 2024-06-12 10:42
 * @description: 某些字段不方便暴露，使用该类将字段暴露给前端
 * 否则可能会逆向出数据库的表结构
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {
	private Integer id;
	//支付流水号
	private String payNo;
	//订单流水号
	private String orderNo;
	//用户账号ID
	private Integer userId;
	//交易金额
	private BigDecimal amount;
}
