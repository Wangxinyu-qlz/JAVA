package main.spring.web;

import main.spring.service.OrderService;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 11:00
 * @description: 充当 Servlet  即控制器 Controller
 **/
public class OrderAction {
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
