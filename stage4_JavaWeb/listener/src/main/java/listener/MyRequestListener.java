package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 11:56
 * @description:
 **/
public class MyRequestListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyRequestListener监听到 request 对象被创建");
		ServletRequest servletRequest = sre.getServletRequest();
		System.out.println("记录访问日志......");
		System.out.println("访问IP=" + servletRequest.getRemoteAddr());
		System.out.println("访问资源=" + ((HttpServletRequest)servletRequest).getRequestURL());

	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyRequestListener监听到 request 对象被销毁");
	}
}
