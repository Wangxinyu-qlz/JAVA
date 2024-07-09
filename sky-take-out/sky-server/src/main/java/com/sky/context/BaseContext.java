package com.sky.context;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-09 18:26
 * @description:
 **/
public class BaseContext {
	public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

	public static void setCurrentId(Long id) {
		threadLocal.set(id);
	}

	public static Long getCurrentId() {
		return threadLocal.get();
	}

	public static void removeCurrentId() {
		threadLocal.remove();
	}
}
