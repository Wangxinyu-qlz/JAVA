package main.spring.dependenceInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 14:35
 * @description:
 **/
public class BaseService<T> {
	@Autowired
	private BaseDAO<T> baseDAO;

	public void save() {
		baseDAO.save();
	}
}
