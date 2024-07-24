package com.sky.service.impl;

import com.sky.dto.GoodsSalesDTO;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.mapper.UserMapper;
import com.sky.service.ReportService;
import com.sky.service.WorkspaceService;
import com.sky.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WorkspaceService workspaceService;

	/**
	 * 统计营业额
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end) {
		ArrayList<LocalDate> dateList = getDateList(begin, end);
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

	private static ArrayList<LocalDate> getDateList(LocalDate begin, LocalDate end) {
		//存放从begin -> end 日期之间每天的日期
		ArrayList<LocalDate> dateList = new ArrayList<>();

		dateList.add(begin);
		while (!begin.equals(end)) {
			//计算指定日期后一天的日期
			begin = begin.plusDays(1);
			dateList.add(begin);
		}
		return dateList;
	}

	/**
	 * 统计指定时间区间内的用户数据
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public UserReportVO getUserStatistics(LocalDate begin, LocalDate end) {
		//存放从begin -> end 日期之间每天的日期
		ArrayList<LocalDate> dateList = getDateList(begin, end);
		String dateString = StringUtils.join(dateList, ",");

		//新增用户数量 select count(id) from user where create_time < ? and create_time > ?
		List<Integer> newUserList = new ArrayList<>();
		//总用户数量 select count(id) from user where create_time < ?
		List<Integer> totalUserList = new ArrayList<>();

		for (LocalDate date : dateList) {
			LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
			LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
			Map map = new HashMap();
			map.put("end", endTime);
			Integer totalUserNum = userMapper.countByMap(map);
			totalUserNum = totalUserNum == null ? 0 : totalUserNum;
			totalUserList.add(totalUserNum);

			map.put("begin", beginTime);
			Integer newUserNum = userMapper.countByMap(map);
			newUserNum = newUserNum == null ? 0 : newUserNum;
			newUserList.add(newUserNum);
		}

		String newUserString = StringUtils.join(newUserList, ",");
		String totalUserString = StringUtils.join(totalUserList, ",");

		return UserReportVO.builder()
				.dateList(dateString)
				.newUserList(newUserString)
				.totalUserList(totalUserString)
				.build();
	}

	/**
	 * 订单统计
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public OrderReportVO getOrdersStatistics(LocalDate begin, LocalDate end) {
		//存放从begin -> end 日期之间每天的日期
		ArrayList<LocalDate> dateList = getDateList(begin, end);
		String dateString = StringUtils.join(dateList, ",");

		//订单总数
		List<Integer> ordersNumList = new ArrayList<>();
		//有效订单数
		List<Integer> validOrdersNumList = new ArrayList<>();

		for (LocalDate date : dateList) {
			LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
			LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);

			//查询每天的订单数量 select count(id) from orders where order_time > begin and order_time < end
			Map map = new HashMap();
			map.put("begin", beginTime);
			map.put("end", endTime);
			Integer orderNum = orderMapper.countByMap(map);
			orderNum = orderNum == null ? 0 : orderNum;

			//查询每天的有效订单数 select count(id) from orders where order_time > begin and order_time < end and status = 5
			map.put("status", Orders.COMPLETED);
			Integer validOrdersNum = orderMapper.countByMap(map);
			validOrdersNum = validOrdersNum == null ? 0 : validOrdersNum;

			ordersNumList.add(orderNum);
			validOrdersNumList.add(validOrdersNum);
		}

		//计算时间区间内的订单总数量
		Integer totalOrderNum = ordersNumList.stream().reduce(Integer::sum).get();
		//计算时间区间内的有效订单数量
		Integer validOrderNum = validOrdersNumList.stream().reduce(Integer::sum).get();
		//计算订单完成率
		Double orderCompletionRate = 0.0;
		if(totalOrderNum != 0) {
			orderCompletionRate = validOrderNum.doubleValue() / totalOrderNum;
		}

		String ordersNumString = StringUtils.join(ordersNumList, ",");
		String valOrdersNumString = StringUtils.join(validOrdersNumList, ",");

		return OrderReportVO.builder()
				.dateList(dateString)
				.orderCountList(ordersNumString)
				.validOrderCountList(valOrdersNumString)
				.totalOrderCount(totalOrderNum)
				.validOrderCount(validOrderNum)
				.orderCompletionRate(orderCompletionRate)
				.build();
	}

	/**
	 * 销量排名top10
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end) {
		LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
		LocalDateTime endTime = LocalDateTime.of(end, LocalTime.MAX);
		List<GoodsSalesDTO> salesTop10 = orderMapper.getSalesTop(beginTime, endTime);

		List<String> names = salesTop10.stream().map(GoodsSalesDTO::getName).collect(Collectors.toList());
		String nameList = StringUtils.join(names, ",");
		List<Integer> numbers = salesTop10.stream().map(GoodsSalesDTO::getNumber).collect(Collectors.toList());
		String numberList = StringUtils.join(numbers, ",");

		return SalesTop10ReportVO.builder()
				.nameList(nameList)
				.numberList(numberList)
				.build();
	}

	/**
	 * 导出最近30天的运营数据
	 *
	 * @param response
	 */
	@Override
	public void exportBusinessData(HttpServletResponse response) {
		//查询数据库，获取营业数据
		LocalDate dateBegin = LocalDate.now().minusDays(30);
		LocalDate dateEnd = LocalDate.now().minusDays(1);//查到昨天，当天数据可能有变动
		//查询概览数据
		BusinessDataVO businessDataVO = workspaceService.getBusinessData(
				LocalDateTime.of(dateBegin, LocalTime.MIN),
				LocalDateTime.of(dateEnd, LocalTime.MAX));
		//通过POI将数据写入到excel文件中
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("template/运营数据报表模板.xlsx");
		try {
			//基于模板文件创建一个新的excel文件
			XSSFWorkbook excel = new XSSFWorkbook(in);
			//获取sheet页
			XSSFSheet sheet = excel.getSheet("Sheet1");

			//填充数据--时间
			sheet.getRow(1).getCell(1).setCellValue("时间：" + dateBegin + "至" + dateEnd);

			//获取并填充第4行
			XSSFRow row = sheet.getRow(3);
			row.getCell(2).setCellValue(businessDataVO.getTurnover());
			row.getCell(4).setCellValue(businessDataVO.getOrderCompletionRate());
			row.getCell(6).setCellValue(businessDataVO.getNewUsers());

			//获取并填充第5行
			row = sheet.getRow(4);
			row.getCell(2).setCellValue(businessDataVO.getValidOrderCount());
			row.getCell(4).setCellValue(businessDataVO.getUnitPrice());

			//填充明细数据
			for (int i = 0; i < 30; i++) {
				LocalDate date = dateBegin.plusDays(i);
				//查询某一天的营业数据
				BusinessDataVO businessDate = workspaceService.getBusinessData(LocalDateTime.of(date, LocalTime.MIN), LocalDateTime.of(date, LocalTime.MAX));

				row = sheet.getRow(7 + i);
				row.getCell(1).setCellValue(date.toString());
				row.getCell(2).setCellValue(businessDate.getTurnover());
				row.getCell(3).setCellValue(businessDate.getValidOrderCount());
				row.getCell(4).setCellValue(businessDate.getOrderCompletionRate());
				row.getCell(5).setCellValue(businessDate.getUnitPrice());
				row.getCell(6).setCellValue(businessDate.getNewUsers());
			}

			//通过输出流将excel文件下载到客户端浏览器
			ServletOutputStream outputStream = response.getOutputStream();
			excel.write(outputStream);

			//关闭流
			outputStream.close();
			excel.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
