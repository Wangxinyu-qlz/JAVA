package qiaolezi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import qiaolezi.springboot.bean.Admin;
import qiaolezi.springboot.bean.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 15:29
 * @description:
 **/
@Controller
public class AdminController {
	//响应用户的登录请求
	@PostMapping("/login")
	//将admin信息放入httpsession
	//如果需要在request域中存放信息传递给下一个页面，可以将信息放入model中
	public String login(Admin admin, HttpSession httpSession, Model model) {
		System.out.println(admin.getUsername() + "\n" + admin.getPassword());
		if (StringUtils.hasText(admin.getUsername()) && "666".equals(admin.getPassword())) {
			//将登陆用户保存到session
			httpSession.setAttribute("loginAdmin", admin);
			//合法 重定向到manage.html
			//不使用请求转发为了防止刷新页面重新提交
			//TODO manage.html  表示查询方法的映射路径为manage.html
			return "redirect:/manage.html";

		} else {
			model.addAttribute("message", "账号/密码错误");
			return "adminLogin";
		}
	}

	@GetMapping("/manage.html")
	public String mainPage(Model model, HttpSession httpSession) {
		Object loginAdmin = httpSession.getAttribute("loginAdmin");
		if (null != loginAdmin) {
			//集合模拟用户数据，放入到request域中，显示
			ArrayList<User> users = new ArrayList<>();
			users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
			users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
			users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
			users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
			users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));
			model.addAttribute("users", users);

			System.out.println(httpSession.getAttribute("loginAdmin"));
			return "manage";//这里才是视图解析器到 /templates/manage.html
		} else {
			//返回登陆页面
			model.addAttribute("message", "请登录");
			return "adminLogin";  //请求转发
		}

	}
}
