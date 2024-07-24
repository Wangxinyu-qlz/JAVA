package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-23 17:00
 * @description:
 **/
public interface ReportService {

	/**
	 * 统计营业额
	 * @return
	 */
	TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

	/**
	 * 用户统计
	 * @param begin
	 * @param end
	 * @return
	 */
	UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

	/**
	 * 订单统计
	 * @param begin
	 * @param end
	 * @return
	 */
	OrderReportVO getOrdersStatistics(LocalDate begin, LocalDate end);

	/**
	 *
	 * 销量排名top10
	 * @param begin
	 * @param end
	 * @return
	 */
	SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
