package com.sky.service;

import com.sky.vo.TurnoverReportVO;

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
}
