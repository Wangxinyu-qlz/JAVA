package com.qlz.controller;


import com.qlz.entities.Pay;
import com.qlz.entity.PayDTO;
import com.qlz.resp.ResultData;
import com.qlz.resp.ReturnCodeEnum;
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
	public ResultData<String> add(@RequestBody Pay pay) {
		System.out.println(pay.toString());
		int i = payService.add(pay);
		//return "成功插入，返回值：" + i;
		return ResultData.success("成功插入，返回值：" + i);
	}

	@DeleteMapping(value = "/pay/del/{id}")
	@Operation(summary = "删除",description = "删除支付流水方法")
	public ResultData<String> del(@PathVariable("id") Integer id) {
		//return payService.delete(id);
		int i = payService.delete(id);
		return ResultData.success("成功删除，返回值：" + i);
	}

	@PutMapping(value = "/pay/update")
	@Operation(summary = "修改",description = "修改支付流水方法")
	public ResultData<String> update(@RequestBody PayDTO payDTO) {
		Pay pay = new Pay();
		//将payDao 复制给 pay
		BeanUtils.copyProperties(payDTO, pay);
		int i = payService.update(pay);
		//return "成功修改记录，返回值：" + i;
		return ResultData.success("成功修改记录，返回值：" + i);
	}

	@GetMapping(value = "/pay/get/{id}")
	@Operation(summary = "按照ID查流水",description = "查询支付流水方法")
	public ResultData<Pay> get(@PathVariable("id") Integer id) {
		//return payService.getById(id);
		if (id == -4)
			throw new RuntimeException("id不能为负数");
		Pay pay = payService.getById(id);
		return ResultData.success(pay);
	}

	@GetMapping(value = "/pay/get")
	@Operation(summary = "查询所有流水",description = "查询支付流水方法")
	public ResultData<List<Pay>> get() {
		//return payService.getAll();
		List<Pay> all = payService.getAll();
		return ResultData.success(all);
	}

	@RequestMapping(value = "/pay/error", method = RequestMethod.GET)
	public ResultData<Integer> getPayError() {
		Integer i = Integer.valueOf(200);
		try {
			System.out.println("--------come here");
			int data = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
		}
		return ResultData.success(i);
	}
}
