package web.viewSolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 14:46
 * @description:
 **/
@Controller
@RequestMapping("/goods")
public class GoodsHandler {
	@RequestMapping("/buy")
	public String buy() {
		System.out.println("-----------buy()--------------");
		//如果这个id在IOC容器中不存在，则按照默认属兔处理器机制处理，如果仍然找不到->404
		return "myView";//这里的名字是MyView解析器的name  @Component(value = "myView")
	}

	@RequestMapping(value = "/order")
	public String order() {
		System.out.println("-----------order()--------------");
		// /WEB-INF/pages/my_view.jsp -> /springMVC/WEB-INF/pages/my_view.jsp
		return "forward:/WEB-INF/pages/my_view.jsp";
	}
}
