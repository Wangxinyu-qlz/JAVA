package com.sky.service;

import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 20:39
 * @description:
 **/
public interface OrderService {

	/**
	 * 用户下单
	 *
	 * @param ordersSubmitDTO
	 * @return
	 */
	OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

	/**
	 * 订单支付
	 *
	 * @param ordersPaymentDTO
	 * @return
	 */
	OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

	/**
	 * 支付成功，修改订单状态
	 *
	 * @param outTradeNo
	 */
	void paySuccess(String outTradeNo);
}
