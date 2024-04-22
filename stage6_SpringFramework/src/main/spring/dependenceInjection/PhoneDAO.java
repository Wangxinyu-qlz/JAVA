package main.spring.dependenceInjection;

import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 14:33
 * @description:
 **/
@Repository
public class PhoneDAO extends BaseDAO<Phone> {
	@Override
	public void save() {
		System.out.println("PhoneDAO 的 save()..");
	}
}
