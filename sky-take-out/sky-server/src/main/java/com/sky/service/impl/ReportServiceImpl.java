package com.sky.service.impl;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.service.ReportService;
import com.sky.vo.TurnoverReportVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-23 17:00
 * @description:
 **/
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {
	@Autowired
	private OrderMapper orderMapper;

	/**
	 * 统计营业额
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end) {
		//存放从begin -> end 日期之间每天的日期
		ArrayList<LocalDate> dateList = new ArrayList<>();

		dateList.add(begin);
		while(!begin.equals(end)) {
			//计算指定日期后一天的日期
			begin = begin.plusDays(1);
			dateList.add(begin);
		}
		String dateString = StringUtils.join(dateList, ",");

		List<Double> turnoverList = new ArrayList<>();
		for (LocalDate date : dateList) {
			//查询date日期对应的营业额，状态为已完成的订单金额
			//select sum(amount) from orders where order_time > ? and order_time < ? and status = 5
			LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
			LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
			Map map = new HashMap();
			map.put("begin", beginTime);
			map.put("end", endTime);
			map.put("status", Orders.COMPLETED);
			Double turnover = orderMapper.sumByMap(map);
			turnover = turnover==null ? 0.0 : turnover;
			turnoverList.add(turnover);
		}
		String turnoverString = StringUtils.join(turnoverList, ",");

		return TurnoverReportVO
				.builder()
				.dateList(dateString)
				.turnoverList(turnoverString)
				.build();
	}
}
