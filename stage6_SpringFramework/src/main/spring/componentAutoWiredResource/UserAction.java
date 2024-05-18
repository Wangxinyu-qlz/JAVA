package main.spring.componentAutoWiredResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 12:27
 * @description: UserAction==UserController @Controller标识该类是一个控制器（Servlet）
 **/
@Controller
public class UserAction {
	//TODO
	// 1.在ioc容器中查找待装配的组件的类型，如果有唯一的bean匹配，则使用该bean装配
	// 2.如果待装配的类型对应的bean在ioc容器中有多个，则使用待装配的属性的属性名作为id值进行查找，找到就装配，否则抛出异常
	//@Autowired

	//@Resource两个重要的属性：name type
	//name属性使用byName的自动注入策略
	//比如@Resource(name = "userService2")将容器中的 id=userService2 的对象装配到 userService 变量中
	//type属性使用byType的自动注入策略
	//@Resource(type = UserService.class)按照 UserService.class 类型进行装配，
	// TODO 要求容器中只能有一个该类型的对象（前提：这里的属性名是userService4，但是容器中是userService1 2 3）
	// TODO 这里的运行结果和老韩的不一致，实测容器中存在多个同类型的bean也可以正常运行，
	//  并且装配的bean的 id 是和这里的 属性名 匹配的（前提：这里的属性名和 容器中的一个bean的id匹配）
	//如果没有指定name 和 type，则首先使用byName的方式装配，如果失败，使用byType方式装配，如果都不成功，报错

	//在启动spring的时候，首先要启动容器；
	//启动spring容器时，会默认寻找容器扫描范围内的可加载bean，然后查找哪些bean上的属性和方法上有@Resource注解；
	//找到@Resource注解后，判断@Resource注解括号中的name属性是否为空，
	//  如果为空：看spring容器中的bean的id与@Resource要注解的那个变量属性名是否相同，
	//      如相同，匹配成功；
	//      如果不相同，看spring容器中bean的id对应的类型是否与@Resource要注解的那个变量属性对应的类型是否相等，
	//          若相等，匹配成功，若不相等，匹配失败。
	//  如果@Resource注解括号中的name属性不为空，
	//      看name的属性值和容器中的bean的id名是否相等，如相等，则匹配成功；如不相等，则匹配失败。
	//@Resource(name = "userService")
	//@Resource(type = UserService.class)
	@Resource()
	private UserService userService4;
	//private UserService userService2;
	public void sayOk() {
		System.out.println("UserAction::sayOK()~");
		System.out.println("UserAction装配的userService属性=" + userService4);
		userService4.hi();
	}
}
