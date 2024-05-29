package qiaolezi.springboot.controller;

import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qiaolezi.springboot.bean.Furn;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 15:21
 * @description:
 **/
@Slf4j //使用Slf4j输出日志
//可以省去@AutoWired注解，但是必须使用final / @NotNull
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class HelloController {

	@RequestMapping("/hello")
	//@ResponseBody//这里不加上访问不到
	public String hello() {
		return "Hello,SpringBoot~";
	}

	//1.
	//@Autowired
	//Furn furn;
	//2.
	private final Furn furn;

	@RequestMapping("/furn")
	public Furn furn() {
		//普通方式
		log.info("furn" + furn);
		//占位符输出
		log.info("furn={} furn2={}", furn, furn);
		return furn;
	}
}
