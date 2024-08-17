package com.qlz.fmmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="ResultVO对象", description = "封装接口返回给前端的数据")
public class ResultVO {
	//响应给前端的状态码
	@ApiModelProperty(value = "响应状态码", name = "code")
	private Integer code;
	//响应给前端的提示信息
	@ApiModelProperty(value = "提示信息", name = "msg")
	private String msg;
	//响应给前端的数据
	@ApiModelProperty(value = "数据", name = "data")
	private Object data;
}
