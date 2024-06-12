package com.qlz.service.impl;

import com.qlz.entities.Pay;
import com.qlz.mapper.PayMapper;
import com.qlz.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mscloud
 * @author: Qiaolezi
 * @create: 2024-06-12 10:45
 * @description:
 **/
@Service
public class PayServiceImpl implements PayService {
	@Resource
	private PayMapper payMapper;

	@Override
	public int add(Pay pay) {
		return payMapper.insertSelective(pay);
	}

	@Override
	public int delete(Integer id) {
		return payMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Pay pay) {
		return payMapper.updateByPrimaryKeySelective(pay);
	}

	@Override
	public Pay getById(Integer id) {
		return payMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Pay> getAll() {
		return payMapper.selectAll();
	}
}
