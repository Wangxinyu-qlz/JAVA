package com.sky.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.spi.ResolveResult;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-22 23:13
 * @description:
 **/
@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Slf4j
@Api("订单先关接口")
public class OrderController {
	@Autowired
	private OrderService orderService;

	/**
	 * 订单搜索
	 * @return
	 */
	@GetMapping("/conditionSearch")
	@ApiOperation("订单搜索")
	public Result<PageResult> conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO) {
		PageResult pageResult = orderService.conditionSearch(ordersPageQueryDTO);

		return Result.success(pageResult);
	}

	/**
	 * 各个状态的订单数量统计
	 * @return
	 */
	@GetMapping("/statistics")
	@ApiOperation("各个状态的订单数量统计")
	public Result<OrderStatisticsVO> statistics() {
		OrderStatisticsVO orderStatisticsVO = orderService.statistics();

		return Result.success(orderStatisticsVO);
	}
}
