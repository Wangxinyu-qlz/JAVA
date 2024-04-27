package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	 *  @RequestMapping() 不指定method，
	 *  jsp/html中的method可以为get、post
	 *
	 * 4.buy() 请求的url: http://ip:port/工程路径//user/buy
	 * @return 请求的文件的名字，在视图解析器中进行解析（拼接）
	 */
	//@GetMapping
	//@PutMapping
	//@DeleteMapping
	@PostMapping(value = "/buy") //简写形式
	//@RequestMapping(value = "/buy", method= RequestMethod.POST)
	public String buy() {
		System.out.println("购买商品");
		return "success";
	}

	/**
	 * params = "bookId"：请求该方法时，必须给一个bookId参数
	 * params = "bookId=100"：请求该方法时，bookId必须=100，都则报错
	 * Parameter conditions "bookId=100" not met for actual request parameters: bookId={200}
	 * params = "bookId!=100"：请求该方法时，bookId必须 !=100，都则报错
	 * Parameter conditions "bookId!=100" not met for actual request parameters: bookId={100}
	 * search(String bookId)：请求目标方法时，携带的 bookId 的值，赋值给 String bookId
	 *
	 * @param bookId
	 * @return 请求的文件的名字
	 */
	@RequestMapping(value = "/find", params = "bookId", method = RequestMethod.GET)
	public String search(String bookId) {
		System.out.println("查询书籍bookId=" + bookId);
		return "success";
	}


	/**
	 * 配置/user/message/aa, /user/message/aa/bb/cc
	 * value = "/message/**"：表示可以匹配多层路径
	 *
	 * @return
	 */
	@RequestMapping(value = "/message/**")
	public String im() {
		System.out.println("发送信息");
		return "success";
	}

	/**
	 * 目标方法获取userName和userId，
	 * <a href="user/register/tom/300">占位符演示</a>
	 * url:   user/register/{username}/{userid}
	 *
	 * @param username
	 * @param userid
	 * @return
	 * @PathVariable("username")("userid") 以上三行的username 和 userid要一致
	 */
	@RequestMapping(value = "/register/{username}/{userid}")
	public String register(@PathVariable("username") String username, @PathVariable("userid") int userid) {
		System.out.println("userName=" + username + " userId=" + userid);
		return "success";
	}

	/**
	 * 映射的url不能重复
	 * web.UserHandler#hi2()
	 * to { [/user/hi]}: There is already 'userHandler' bean method
	 * web.UserHandler#hi() mapped.
	 * @return
	 */
	@RequestMapping(value = "/hi")
	public String hi() {
		System.out.println("hi");
		return "success";
	}

	//@RequestMapping(value = "/hi")
	//public String hi2() {
	//	System.out.println("hi");
	//	return "success";
	//}

	/**
	 * 如果请求的参数有 email=xxx ，将其值 赋给 String email
	 * 名称必须保持一致，否则无法接受数据，-> null
	 * @param email
	 * @return
	 */
	@GetMapping(value = "/hello3")
	public String hello3(String email) {
		System.out.println("hello3 email:  " + email);
		return "success";
	}
}
