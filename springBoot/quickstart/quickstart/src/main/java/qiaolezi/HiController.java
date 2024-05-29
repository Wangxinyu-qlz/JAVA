package qiaolezi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 15:55
 * @description:
 **/
@RestController
public class HiController {
	//从application.properties文件获取
	@Value("${my.website}")
	private String website;

	@RequestMapping("/hi")
	public String hi() {
		System.out.println("website: " + website);
		return "hi";
	}
}
