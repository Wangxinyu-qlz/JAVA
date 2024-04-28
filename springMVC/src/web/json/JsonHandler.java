package web.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.json.entity.Dog;
import web.json.entity.User;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 21:41
 * @description:
 **/
@Controller
public class JsonHandler {
	@RequestMapping(value = "/json/dog")
	//@ResponseBody：SpringMVC会根据目标方法的这个注解，返回指定格式，根据http请求处理
	@ResponseBody
	public Dog getJson() {
		Dog dog = new Dog();
		dog.setName("大黄");
		dog.setAddress("山海");

		return dog;
	}

	//TODO @RequestBody User user
	//springMVC会将提交的 json 字符串数据填充给指定的JavaBean
	@ResponseBody
	@RequestMapping(value = "/save2")
	public User save2(@RequestBody User user) {
		System.out.println("user=" + user);
		return user;
	}
}
