package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-24 15:50
 * @description:
 **/
//1.如果使用SpringMVC，在一个类上标识@Controller
//2.表示将该类是为一个控制器，注入到spring容器中
@Controller
public class UserServlet {
	/**
	 * 1.login()方法用于响应用户的登录请求
	 * 2.@RequestMapping(value = "/login") 类似原生Servlet配置的url-pattern
	 * 3.当用户在浏览器输入http://localhost:8080/web工程路径[配置的servlet里面的路径springMVC]/login 可以访问到该方法
	 * 4.return "login_ok"; 表示返回结果给视图解析器(InternalResourceViewResolver)
	 * 视图解析器会根据配置，决定跳转到哪个页面
	 *
	 *     <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 *         <!--配置前缀和后缀属性-->
	 *         <property name="prefix" value="/WEB-INF/pages/"/>
	 *         <property name="suffix" value=".jsp"/>
	 *     </bean>
	 * 根据上面的配置 return "login_ok"; 就是转发到//WEB-INF/pages/login_ok.jsp
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("login_ok...");
		return "login_ok";
	}
}