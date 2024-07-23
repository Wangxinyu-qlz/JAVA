package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.TurnoverReportVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-23 16:55
 * @description:
 **/
@RestController
@RequestMapping("/admin/report")
@Slf4j
@Api("数据统计相关接口")
public class ReportController {
	@Autowired
	private ReportService reportService;

	@GetMapping("/turnoverStatistics")
	@ApiOperation("营业额统计")
	public Result<TurnoverReportVO> turnoverStatistics(
			@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
			@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
		log.info("营业额统计：{}，{}", begin, end);
		TurnoverReportVO turnoverReportVO = reportService.getTurnoverStatistics(begin, end);

		return Result.success(turnoverReportVO);
	}
}
