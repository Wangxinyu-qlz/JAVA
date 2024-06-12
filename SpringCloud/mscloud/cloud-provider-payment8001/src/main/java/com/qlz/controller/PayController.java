package com.qlz.controller;


import com.qlz.entities.Pay;
import com.qlz.entities.PayDTO;
import com.qlz.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: mscloud
 * @author: Qiaolezi
 * @create: 2024-06-12 10:47
 * @description:
 **/
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
	@Autowired
	private PayService payService;

	@PostMapping(value = "/pay/add")
	@Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
	public String add(@RequestBody Pay pay) {
		System.out.println(pay.toString());
		int i = payService.add(pay);
		return "成功插入，返回值：" + i;
	}

	@DeleteMapping(value = "/pay/del/{id}")
	@Operation(summary = "删除",description = "删除支付流水方法")
	public Integer del(@PathVariable("id") Integer id) {
		return payService.delete(id);
	}

	@PutMapping(value = "/pay/update")
	@Operation(summary = "修改",description = "修改支付流水方法")
	public String update(@RequestBody PayDTO payDTO) {
		Pay pay = new Pay();
		//将payDao 复制给 pay
		BeanUtils.copyProperties(payDTO, pay);
		int i = payService.update(pay);
		return "成功修改记录，返回值：" + i;
	}

	@GetMapping(value = "/pay/get/{id}")
	@Operation(summary = "按照ID查流水",description = "查询支付流水方法")
	public Pay get(@PathVariable("id") Integer id) {
		return payService.getById(id);
	}

	@GetMapping(value = "/pay/get")
	@Operation(summary = "查询所有流水",description = "查询支付流水方法")
	public List<Pay> get() {
		return payService.getAll();
	}
}
