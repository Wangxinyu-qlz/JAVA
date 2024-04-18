package main.spring.component;

import org.springframework.stereotype.Service;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 12:26
 * @description: @Service 标识该类是一个Service类
 **/
@Service
public class UserService {
	public void hi() {
		System.out.println("UserService::hi()~");
	}
}
