package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-24 18:08
 * @description:
 **/
@RequestMapping(value = "/user")
@Controller
public class UserHandler {
	/**
	 * 1.method-RequestMethod.POST:表示请求buy目标方法必须是 POST
	 * 2.RequestMethod ： POST GET PUT DELETE
	 * 3.SpringMVC 控制器默认支持GET POST
	 *
	 * 4.buy() 请求的url: http://ip:port/工程路径//user/buy
	 * @return
	 */
	@RequestMapping(value = "/buy", method= RequestMethod.POST)
	public String buy() {
		System.out.println("购买商品");
		return "success";
	}
}
