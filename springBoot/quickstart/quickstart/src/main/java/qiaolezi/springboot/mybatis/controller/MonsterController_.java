package qiaolezi.springboot.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiaolezi.springboot.mybatis.bean.Monster;
import qiaolezi.springboot.mybatis.service.MonsterService;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:27
 * @description:
 **/
@Controller
public class MonsterController_ {
	@Autowired
	MonsterService monsterService;

	@ResponseBody
	@GetMapping("/monster-mybatis")
	public Monster getByMonsterId(@RequestParam("id") Integer id) {

		return monsterService.getMonsterById(id);

	}
}
