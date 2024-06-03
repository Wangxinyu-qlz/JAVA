package qiaolezi.springboot.controller;

import org.springframework.web.bind.annotation.*;
import qiaolezi.springboot.bean.Monster3;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 09:54
 * @description:
 **/
@RestController
public class ParameterController {
	@GetMapping("/monster/{id}/{name}")
	public String pathVariable(@PathVariable("id") String id,
	                           @PathVariable("name") String name,
	                           @PathVariable Map<String, String> map,
	                           @RequestHeader("Host") String host,
	                           @RequestHeader Map<String, String> header) {
		//id:100
		//name:king
		//host:localhost:8080
		//header:{host=localhost:8080, connection=keep-alive, sec-ch-ua="Google Chrome";
		// v="125", "Chromium";v="125", "Not.A/Brand";v="24", sec-ch-ua-mobile=?0,
		// sec-ch-ua-platform="Windows", upgrade-insecure-requests=1, user-agent=Mozilla/5.0
		// (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
		// Chrome/125.0.0.0 Safari/537.36, accept=text/html,application/xhtml+xml,
		// application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,
		// application/signed-exchange;v=b3;q=0.7, sec-fetch-site=same-origin,
		// sec-fetch-mode=navigate, sec-fetch-user=?1, sec-fetch-dest=document,
		// referer=http://localhost:8080/index.html, accept-encoding=gzip, deflate,
		// br, zstd, accept-language=zh-CN,zh;q=0.9,en;q=0.8, cookie=Idea-8296f673=
		// a99977fc-3834-4832-9a62-2486289c3988}
		//map:{name=king, id=100}
		System.out.println("id:" + id + "\nname:" + name + "\nhost:" + host + "\nheader:" + header);
		System.out.println("map:" + map);
		return "id:" + id + "\nname:" + name + "\nhost:" + host + "\nheader:" + header + "\n\nsuccess";
	}

	@GetMapping("/requestHeader")
	public String requestHeader(@RequestHeader("Host")String host,
	                            @RequestHeader Map<String, String> header) {
		System.out.println("host:" + host + "\nheader:" + header);
		return "success";
	}

	@GetMapping("/hi")
	public String hi(@RequestParam("name")String name,
	                 @RequestParam("fruit")List<String> fruit,
	                 @RequestParam Map<String, String> paras) {
		//name: 韩顺平
		//fruit:[apple, pear]
		//paras:{name= 韩顺平, fruit=apple}
		System.out.println("name:" + name + "\nfruit:" + fruit + "\nparas:" + paras);
		return "success";
	}

	//1. value = "cookie_key" 表示接收名字为cookie_key 的cookie
	//2. 如果浏览器携带来对应的cookie , 那么后面的参数是String ,则接收到的是对应对value
	//3. 后面的参数是Cookie ,则接收到的是封装好的对应的cookie
	@GetMapping("/cookie")
	public String cookie(@CookieValue(value = "cookie-key", required = false)String cookie_value,
	                     @CookieValue(value = "username", required = false) Cookie cookie) {
		//cookie_value:null
		//cookie:null
		System.out.println("cookie_value:" + cookie_value + "\ncookie:" + cookie);
		return "success";
	}

	//content:name=1&age=1
	@PostMapping("/save")
	public String postMethod(@RequestBody String content) {
		System.out.println("content:" + content);
		return "success";
	}

	@PostMapping("savemonster")
	public String saveMethod(Monster3 monster3) {
		//自动类型转换与格式化  级联封装
		//monster3:Monster3(id=100, name=牛魔王, age=120, isMarried=true,
		// birth=Sat Nov 11 00:00:00 CST 2000, car=Car(name=法拉利, price=99999.9))
		System.out.println("monster3:" + monster3);
		return "success";
	}
}
