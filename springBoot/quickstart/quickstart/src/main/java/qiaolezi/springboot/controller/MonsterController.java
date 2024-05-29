package qiaolezi.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qiaolezi.springboot.bean.Monster2;

import javax.annotation.Resource;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:58
 * @description:
 **/
@RestController
public class MonsterController {
	@Resource
	private Monster2 monster2;
	@RequestMapping("/monster")
	public Monster2 monster() {
		return monster2;
	}
}
