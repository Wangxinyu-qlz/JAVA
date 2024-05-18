package main.spring.practice.annotation_component;

import org.springframework.stereotype.Service;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 12:02
 * @description:
 **/
@Service
public class UserService {
	public void hi() {
		System.out.println("UserService::hi()");
	}
}
