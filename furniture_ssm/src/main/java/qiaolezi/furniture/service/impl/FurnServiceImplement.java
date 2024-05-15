package qiaolezi.furniture.service.impl;

import org.springframework.stereotype.Service;
import qiaolezi.furniture.bean.Furn;
import qiaolezi.furniture.dao.FurnMapper;
import qiaolezi.furniture.service.FurnService;

import javax.annotation.Resource;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-10 17:13
 * @description:
 **/
@Service
public class FurnServiceImplement implements FurnService {

	//注入FurnMapper接口对象（代理对象）
	@Resource
	private FurnMapper furnMapper;

	@Override
	public void save(Furn furn) {
		//因为furniture表的字段id是自增的，因此使用insertSelective
		furnMapper.insertSelective(furn);
	}
}
