package main.mySQL.practice.tx.service;

import main.mySQL.practice.tx.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-22 11:45
 * @description:
 **/
@Service
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;

	public void bugGoods(int user_id, int goods_id, int num) {
		Float price = goodsDao.selectById(goods_id);
		goodsDao.updateBalance(user_id, price * num);
		goodsDao.updateAmount(goods_id, num);
	}

	@Transactional
	public void bugGoods_Exception(int user_id, int goods_id, int num) {
		Float price = goodsDao.selectById(goods_id);
		goodsDao.updateBalance(user_id, price * num);
		int i = 1 / 0;
		goodsDao.updateAmount(goods_id, num);
	}
}
