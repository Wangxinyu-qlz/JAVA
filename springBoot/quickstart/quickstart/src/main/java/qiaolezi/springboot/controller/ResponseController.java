package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qiaolezi.springboot.bean.Car;
import qiaolezi.springboot.bean.Monster3;

import java.util.Date;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 11:23
 * @description:
 **/
@Controller
public class ResponseController {
	//底层机制：返回值处理器的消息转换器进行处理
	//Accept:
	//text/html,application/xhtml+xml,application/xml;q=0.9,
	// image/avif,image/webp,image/apng,*/*;q=0.8,
	// application/signed-exchange;v=b3;q=0.7

	//1.    contentnegotiation:
	//        favor-parameter: true  # 开启基于请求参数的内容协商功能
	//2.请求时指定format
	//http://localhost:8080/get/monster?format=json   返回json
	//http://localhost:8080/get/monster               返回xml
	@ResponseBody
	@GetMapping("/get/monster")
	public Monster3 getMonster() {
		Monster3 monster3 = new Monster3();
		Car car = new Car();
		car.setName("奔驰");
		car.setPrice(1000000.1);
		monster3.setId(100);
		monster3.setName("奔波霸");
		monster3.setAge(500);
		monster3.setBirth(new Date());
		monster3.setIsMarried(false);
		monster3.setCar(car);
		return monster3;
	}
}
