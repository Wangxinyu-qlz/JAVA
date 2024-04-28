package web.viewSolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 14:47
 * @description:
 * 1.extends AbstractView -> MyView可以作为一个视图使用
 * 2.@Component(value = "myView") 作为组件注入到容器中
 **/
@Component(value = "myView")
public class MyView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
	                                       HttpServletRequest request,
	                                       HttpServletResponse response) throws Exception {

		//完成视图渲染
		//确定要跳转的页面 /WEB-INF/pages/my_view.jsp
		System.out.println("进入到自己的视图");

		//请求转发到 /WEB-INF/pages/my_view.jsp --> /springMVC/WEB-INF/pages/my_view.jsp
		request.getRequestDispatcher("/WEB-INF/pages/my_view.jsp").
				forward(request ,response);

	}
}
