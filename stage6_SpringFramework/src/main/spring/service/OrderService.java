package main.spring.service;
import main.spring.dao.OrderDao;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 10:59
 * @description:
 **/
public class OrderService {
	private OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
