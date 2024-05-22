package main.mySQL.practice.tx_practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 15:40
 * @description:
 **/
@Service
public class MultiplyService {
	@Resource
	private GoodsService goodsService;

	@Transactional
	public void multiService_propagation_REQUIRES_NEW(int user_id, int goods_id, int goods_num) {
		goodsService.buyGoodsException_Transactional_propagation_REQUIRES_NEW_1(user_id, goods_id, goods_num);
		goodsService.buyGoodsException_Transactional_propagation_REQUIRES_NEW_2(user_id, goods_id, goods_num);
	}

	@Transactional
	public void multiService_propagation_REQUIRED(int user_id, int goods_id, int goods_num) {
		goodsService.buyGoodsException_Transactional_propagation_REQUIRED_1(user_id, goods_id, goods_num);
		goodsService.buyGoodsException_Transactional_propagation_REQUIRED_2(user_id, goods_id, goods_num);
	}
}
