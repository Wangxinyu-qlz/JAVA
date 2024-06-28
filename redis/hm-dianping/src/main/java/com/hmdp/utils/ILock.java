package com.hmdp.utils;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-28 16:43
 * @description:
 **/
public interface ILock {

	/**
	 * 尝试获取锁
	 * @param timeoutSec 锁持有的时间，获取后自动释放
	 * @return true获取成功；false获取失败
	 */
	boolean tryLock(Long timeoutSec);

	/**
	 * 释放锁
	 */
	void unlock();
}
