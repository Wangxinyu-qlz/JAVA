package main.spring.dependenceInjection;

import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 14:33
 * @description:
 **/
@Repository
public class BookDAO extends BaseDAO<Book> {
	@Override
	public void save() {
		System.out.println("BookDAO 的 save()..");
	}
}
