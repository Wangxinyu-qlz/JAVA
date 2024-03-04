package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 11:31
 * @description:
 **/
public class MyHttpSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		//当session被创建时，设置他的生命周期为10s
		session.setMaxInactiveInterval(10);
		System.out.println("MyHttpSessionListener监听到：" +
				session.getId() + "被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		//用户关闭浏览器，关闭页面，不会立即销毁session，session的生命周期由服务器维护
		System.out.println("MyHttpSessionListener监听到：" +
				session.getId() + "被销毁");
	}
}
