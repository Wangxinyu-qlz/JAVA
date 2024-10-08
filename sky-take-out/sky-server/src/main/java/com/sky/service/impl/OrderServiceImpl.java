package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.dto.*;
import com.sky.entity.*;
import com.sky.exception.AddressBookBusinessException;
import com.sky.exception.OrderBusinessException;
import com.sky.exception.ShoppingCartBusinessException;
import com.sky.mapper.*;
import com.sky.result.PageResult;
import com.sky.service.OrderService;
import com.sky.utils.WeChatPayUtil;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import com.sky.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 20:39
 * @description:
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Autowired
	private AddressBookMapper addressBookMapper;
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WeChatPayUtil weChatPayUtil;
	@Autowired
	private WebSocketServer webSocketServer;

	/**
	 * 用户下单
	 *
	 * @param ordersSubmitDTO
	 * @return
	 */
	@Override
	@Transactional
	public OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO) {
		//信息校验，处理业务异常（地址簿、购物车为null）
		AddressBook addressBook = addressBookMapper.getById(ordersSubmitDTO.getAddressBookId());
		if (addressBook == null) {
			throw new AddressBookBusinessException(MessageConstant.ADDRESS_BOOK_IS_NULL);
		}
		Long currentId = BaseContext.getCurrentId();
		ShoppingCart shoppingCart = ShoppingCart.builder().id(currentId).build();
		List<ShoppingCart> shoppingCartList = shoppingCartMapper.list(shoppingCart);
		if (shoppingCartList == null || shoppingCartList.isEmpty()) {
			throw new ShoppingCartBusinessException(MessageConstant.SHOPPING_CART_IS_NULL);
		}
		//向订单插入一条数据
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersSubmitDTO, orders);
		orders.setOrderTime(LocalDateTime.now());
		orders.setPayStatus(Orders.UN_PAID);
		orders.setStatus(Orders.PENDING_PAYMENT);
		orders.setNumber(String.valueOf(System.currentTimeMillis()));//订单号
		orders.setPhone(addressBook.getPhone());
		orders.setConsignee(addressBook.getConsignee());
		orders.setUserId(currentId);

		orderMapper.insert(orders);

		List<OrderDetail> orderDetailList = new ArrayList<>();
		//向订单明细表插入n条数据
		for (ShoppingCart cart : shoppingCartList) {
			OrderDetail orderDetail = new OrderDetail();
			BeanUtils.copyProperties(cart, orderDetail);
			orderDetail.setOrderId(orders.getId());//设置关联的订单id
			orderDetailList.add(orderDetail);
		}
		//批量插入
		orderDetailMapper.insertBatch(orderDetailList);

		//清空当前用户的购物车数据
		shoppingCartMapper.deleteByUserId(currentId);

		//封装VO返回结果
		OrderSubmitVO orderSubmitVO = OrderSubmitVO.builder()
				.id(orders.getId())
				.orderTime(orders.getOrderTime())
				.orderAmount(orders.getAmount())
				.orderNumber(orders.getNumber())
				.build();

		return orderSubmitVO;
	}

	/**
	 * 订单支付
	 *
	 * @param ordersPaymentDTO
	 * @return
	 */
	public OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception {
		// 当前登录用户id
		Long userId = BaseContext.getCurrentId();
		User user = userMapper.getById(userId);

		//调用微信支付接口，生成预支付交易单
		JSONObject jsonObject = weChatPayUtil.pay(
				ordersPaymentDTO.getOrderNumber(), //商户订单号
				new BigDecimal(0.01), //支付金额，单位 元
				"苍穹外卖订单", //商品描述
				user.getOpenid() //微信用户的openid
		);

		if (jsonObject.getString("code") != null && jsonObject.getString("code").equals("ORDERPAID")) {
			throw new OrderBusinessException("该订单已支付");
		}

		OrderPaymentVO vo = jsonObject.toJavaObject(OrderPaymentVO.class);
		vo.setPackageStr(jsonObject.getString("package"));

		return vo;
	}

	/**
	 * 支付成功，修改订单状态
	 *
	 * @param outTradeNo
	 */
	public void paySuccess(String outTradeNo) {

		// 根据订单号查询订单
		Orders ordersDB = orderMapper.getByNumber(outTradeNo);

		// 根据订单id更新订单的状态、支付方式、支付状态、结账时间
		Orders orders = Orders.builder()
				.id(ordersDB.getId())
				.status(Orders.TO_BE_CONFIRMED)
				.payStatus(Orders.PAID)
				.checkoutTime(LocalDateTime.now())
				.build();

		orderMapper.update(orders);

		//通过websocket向客户端浏览器推送消息 type orderId content
		Map map = new HashMap<>();
		map.put("type", 1);//1:订单提醒 2:客户催单
		map.put("orderId", ordersDB.getId());
		map.put("content", "订单号：" + outTradeNo);

		String string = JSONObject.toJSONString(map);
		webSocketServer.sendToAllClient(string);
	}

	/**
	 * 历史订单分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param status
	 * @return
	 */
	@Override
	public PageResult pageQuery4User(int pageNum, int pageSize, Integer status) {
		PageHelper.startPage(pageNum, pageSize);
		OrdersPageQueryDTO ordersPageQueryDTO = new OrdersPageQueryDTO();

		ordersPageQueryDTO.setUserId(BaseContext.getCurrentId());
		ordersPageQueryDTO.setStatus(status);

		Page<Orders> page = orderMapper.pageQuery(ordersPageQueryDTO);
		ArrayList<OrderVO> orderVOList = new ArrayList<>();
		if(page != null && page.getTotal() > 0) {
			for(Orders order : page) {
				Long id = order.getId();
				List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderId(id);

				OrderVO orderVO = new OrderVO();
				BeanUtils.copyProperties(order, orderVO);
				orderVO.setOrderDetailList(orderDetailList);

				orderVOList.add(orderVO);
			}
		}

		return new PageResult(page.getTotal(), orderVOList);
	}

	/**
	 * 查询订单详情
	 * @param id
	 * @return
	 */
	@Override
	public OrderVO getOrderDetailByOrderId(Long id) {
		Orders orders = orderMapper.getById(id);
		List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderId(orders.getId());

		OrderVO orderVO = new OrderVO();
		BeanUtils.copyProperties(orders, orderVO);
		orderVO.setOrderDetailList(orderDetailList);
		return orderVO;
	}

	/**
	 * 取消订单
	 *
	 * @param id
	 */
	@Override
	public void cancel(Long id) throws Exception {
		// 根据id查询订单
		Orders ordersDB = orderMapper.getById(id);

		// 校验订单是否存在
		if (ordersDB == null) {
			throw new OrderBusinessException(MessageConstant.ORDER_NOT_FOUND);
		}

		//订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
		if (ordersDB.getStatus() > 2) {
			throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
		}

		Orders orders = new Orders();
		orders.setId(ordersDB.getId());

		// 订单处于待接单状态下取消，需要进行退款
		if (ordersDB.getStatus().equals(Orders.TO_BE_CONFIRMED)) {
			//调用微信支付退款接口
			weChatPayUtil.refund(
					ordersDB.getNumber(), //商户订单号
					ordersDB.getNumber(), //商户退款单号
					new BigDecimal(0.01),//退款金额，单位 元
					new BigDecimal(0.01));//原订单金额

			//支付状态修改为 退款
			orders.setPayStatus(Orders.REFUND);
		}

		// 更新订单状态、取消原因、取消时间
		orders.setStatus(Orders.CANCELLED);
		orders.setCancelReason("用户取消");
		orders.setCancelTime(LocalDateTime.now());
		orderMapper.update(orders);
	}

	/**
	 * 再来一单
	 * 流程：将订单详情中的数据，复制一份到购物车中，然后重新下单
	 * @param id
	 */
	@Override
	public void repetition(Long id) {
		//获得当前用户id
		Long userId = BaseContext.getCurrentId();
		//获得当前订单详情
		List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderId(id);
		//将订单详情对象转换为购物车对象
		List<ShoppingCart> shoppingCartList = orderDetailList.stream().map(x -> {
			ShoppingCart shoppingCart = new ShoppingCart();

			//将原订单详情里面的菜品信息重新复制到购物车对象
			//忽略主键id
			BeanUtils.copyProperties(x, shoppingCart, "id");
			shoppingCart.setUserId(userId);
			shoppingCart.setCreateTime(LocalDateTime.now());

			return shoppingCart;
		}).collect(Collectors.toList());

		shoppingCartMapper.insertBatch(shoppingCartList);
	}

	/**
	 * 订单搜索
	 * @param ordersPageQueryDTO
	 * @return
	 */
	@Override
	public PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO) {
		PageHelper.startPage(ordersPageQueryDTO.getPage(), ordersPageQueryDTO.getPageSize());
		Page<Orders> ordersPage = orderMapper.pageQuery(ordersPageQueryDTO);

		//通过page得到OrderVOList
		ArrayList<OrderVO> orderVOList = new ArrayList<>();
		List<Orders> orderList = ordersPage.getResult();

		if (!CollectionUtils.isEmpty(orderList)) {
			for (Orders orders : orderList) {
				OrderVO orderVO = new OrderVO();
				BeanUtils.copyProperties(orders, orderVO);

				//将订单菜品信息拼接为字符串
				List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderId(orders.getId());
				List<String> orderDishList = orderDetailList.stream().map(x -> {
					String orderDish = x.getName() + "*" + x.getNumber() + ";";
					return orderDish;
				}).collect(Collectors.toList());
				String orderDishLists = String.join("", orderDishList);

				orderVO.setOrderDishes(orderDishLists);
				orderVOList.add(orderVO);
			}
		}

		return new PageResult(ordersPage.getTotal(), orderVOList);
	}

	/**
	 * 统计各个状态订单的数量
	 * @return
	 */
	@Override
	public OrderStatisticsVO statistics() {
		//统计status == 2 3 4的订单数量
		Integer toBeConfirmed = orderMapper.countStatus(Orders.TO_BE_CONFIRMED);
		Integer confirmed = orderMapper.countStatus(Orders.CONFIRMED);
		Integer deliveryInProgress = orderMapper.countStatus(Orders.DELIVERY_IN_PROGRESS);

		OrderStatisticsVO orderStatisticsVO = new OrderStatisticsVO();
		orderStatisticsVO.setToBeConfirmed(confirmed);
		orderStatisticsVO.setConfirmed(deliveryInProgress);
		return orderStatisticsVO;
	}

	/**
	 * 取消订单
	 * @param ordersCancelDTO
	 * @throws Exception
	 */
	@Override
	public void cancel(OrdersCancelDTO ordersCancelDTO) throws Exception {
		Orders ordersDB = orderMapper.getById(ordersCancelDTO.getId());
		Integer payStatus = ordersDB.getPayStatus();

		//如果已支付，需要退款
		if(payStatus == 1) {
			String refund = weChatPayUtil.refund(
					ordersDB.getNumber(),
					ordersDB.getNumber(),
					new BigDecimal(0.01),
					new BigDecimal(0.01));
			log.info("申请退款：{}", refund);
		}

		//根据订单id更新订单状态、取消原因、取消时间
		Orders orders = new Orders();
		orders.setId(ordersCancelDTO.getId());
		orders.setStatus(Orders.CANCELLED);
		orders.setCancelReason(ordersCancelDTO.getCancelReason());
		orders.setCancelTime(LocalDateTime.now());
		orderMapper.update(orders);
	}

	/**
	 * 接单
	 * @param ordersConfirmDTO
	 */
	@Override
	public void confirm(OrdersConfirmDTO ordersConfirmDTO) {
		Orders orders = Orders.builder()
				.id(ordersConfirmDTO.getId())
				.status(Orders.CONFIRMED)
				.build();

		orderMapper.update(orders);
	}

	/**
	 * 拒单
	 * @param ordersRejectionDTO
	 */
	@Override
	public void reject(OrdersRejectionDTO ordersRejectionDTO) throws Exception {
		Orders ordersDB = orderMapper.getById(ordersRejectionDTO.getId());

		if(ordersDB==null || !ordersDB.getStatus().equals(Orders.TO_BE_CONFIRMED)) {
			throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
		}

		//支付状态
		Integer payStatus = ordersDB.getPayStatus();
		if(payStatus == Orders.PAID) {//退款
			String refund = weChatPayUtil.refund(
					ordersDB.getNumber(),
					ordersDB.getNumber(),
					new BigDecimal(0.01),
					new BigDecimal(0.01));
			log.info("申请退款：{}", refund);
		}

		//更新订单的状态、拒单原因、取消时间
		Orders orders = new Orders();
		orders.setStatus(Orders.CANCELLED);
		orders.setCancelReason(ordersRejectionDTO.getRejectionReason());
		orders.setId(ordersDB.getId());
		orders.setCancelTime(LocalDateTime.now());
		orderMapper.update(orders);
	}

	/**
	 * 派送订单
	 * 将订单状态改为派送中，只有状态为待派送的订单才能执行此操作
	 * @param id
	 */
	@Override
	public void delivery(Long id) {
		Orders ordersDB = orderMapper.getById(id);
		//校验订单状态
		if(ordersDB==null || !ordersDB.getStatus().equals(Orders.CONFIRMED)) {
			throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
		}

		Orders orders = Orders.builder()
				.status(Orders.DELIVERY_IN_PROGRESS)
				.id(ordersDB.getId())
				.build();
		orderMapper.update(orders);
	}

	/**
	 * 完成订单
	 * @param id
	 */
	@Override
	public void complete(Long id) {
		Orders ordersDB = orderMapper.getById(id);
		if(ordersDB==null || !ordersDB.getStatus().equals(Orders.DELIVERY_IN_PROGRESS)) {
			throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
		}

		Orders orders = Orders.builder()
				.id(ordersDB.getId())
				.status(Orders.COMPLETED)
				.build();
		orderMapper.update(orders);
	}

	@Override
	public void reminder(Long id) {
		Orders ordersDB = orderMapper.getById(id);

		if(ordersDB==null) {
			throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
		}

		//通过websocket推送消息
		Map map = new HashMap<>();
		map.put("type", 2);
		map.put("orderId", id);
		map.put("content", "客户催单：" + ordersDB.getNumber());

		String json = JSON.toJSONString(map);
		webSocketServer.sendToAllClient(json);
	}
}
