package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import qiaolezi.springboot.exception.AccessException;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 11:35
 * @description:
 **/
@Controller
public class MyErrorController {
	@GetMapping(value = {"/err"})
	public String error() {
		int i = 1 / 0;
		return "manage";
	}

	@PostMapping(value = {"err2"})
	public String error2() {
		return "manage";
	}

	@GetMapping(value = {"/err3"})
	public String err3(String name) {
		if(!"tom".equals(name)) {
			throw new AccessException();
		}
		return "manage";
	}
}
