package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 20:43
 * @description:
 **/
@Mapper
public interface OrderDetailMapper {

	/**
	 * 批量插入订单明细数据
	 * @param orderDetailList
	 */
	void insertBatch(List<OrderDetail> orderDetailList);

	/**
	 * 根据orderId查询订单详细信息
	 * @param id
	 * @return
	 */
	@Select("select * from order_detail where order_id = #{orderId}")
	List<OrderDetail> getByOrderId(Long id);

}
