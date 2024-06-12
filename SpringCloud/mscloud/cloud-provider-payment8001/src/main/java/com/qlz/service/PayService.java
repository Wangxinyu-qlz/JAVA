package com.qlz.service;

import com.qlz.entities.Pay;

import java.util.List;

/**
 * @program: mscloud
 * @author: Qiaolezi
 * @create: 2024-06-12 10:44
 * @description:
 **/
public interface PayService {
	public int add(Pay pay);

	public int delete(Integer id);

	public int update(Pay pay);

	public Pay getById(Integer id);

	public List<Pay> getAll();
}
