package main.spring.bean;

import java.util.List;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-15 15:38
 * @description: 书店类
 **/
public class BookStore {
	private List<String> bookList;

	//TODO 如果没有其他构造器，无参构造器可以省略
	// 否则，无参构造器 必须有！
	public BookStore() {

	}

	public List<String> getBookList() {
		return bookList;
	}

	public void setBookList(List<String> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "BookStore{" +
				"bookList=" + bookList +
				'}';
	}
}
