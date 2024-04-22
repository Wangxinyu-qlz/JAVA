package main.spring.dependenceInjection;

import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 14:31
 * @description: 自定义泛型类
 **/
@Repository
public abstract class BaseDAO<T> {
	public abstract void save();
}
