package qiaolezi.springboot.mybatis_plus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiaolezi.springboot.mybatis_plus.bean.Monster2;
import qiaolezi.springboot.mybatis_plus.service.MonsterService2;

import java.util.List;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:27
 * @description:
 **/
@Controller
public class MonsterController2 {
	@Autowired
	MonsterService2 monsterService;

	@ResponseBody
	@GetMapping("/monster-mybatisplus")
	public Monster2 getByMonsterId(@RequestParam("id") Integer id) {
		return monsterService.getById(id);

	}

	/**
	 * 后面老师会讲解分页查询
	 *
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	public List<Monster2> listMonster() {
		return monsterService.list();
	}
}
