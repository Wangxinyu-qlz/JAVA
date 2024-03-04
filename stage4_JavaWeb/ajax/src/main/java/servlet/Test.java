package servlet;

import ajax.entity.User;
import com.google.gson.Gson;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 22:10
 * @description:
 **/
public class Test {
	public static void main(String[] args) {
		User user = new User(100, "1", "000", "123");
		String json = new Gson().toJson(user);
		System.out.println(json);

	}
}
