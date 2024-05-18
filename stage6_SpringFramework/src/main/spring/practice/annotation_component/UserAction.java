package main.spring.practice.annotation_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-18 12:02
 * @description:
 **/
@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	public void say() {
		System.out.println("UserAction::say()");
		System.out.println("装配的UserService==" + userService);
		userService.hi();
	}
}
