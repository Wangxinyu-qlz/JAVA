package main.mySQL.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-24 11:16
 * @description:
 **/
@Service
public class MultiplyService {
	@Resource
	private GoodsService goodsService;

	//当前buyGoodsByTx 和 buyGoodsByTx2 的传播属性是 REQUIRED[会当做一个整体事务管理]只要其中一个出现异常，都会回滚
	//如果在将这两个事务的 传播属性 设置为 @Transactional(propagation = Propagation.REQUIRES_NEW)
	//这两个事务的方法时独立的，不会互相影响，
	//即 一个方法失败 不会导致 另一个方法回滚
	@Transactional
	public void multiBuyGoods(int userId, int goodsId, int amount) {
		goodsService.buyGoodsByTx(userId, goodsId, amount);
		goodsService.buyGoodsByTx2(userId, goodsId, amount);
	}
}
