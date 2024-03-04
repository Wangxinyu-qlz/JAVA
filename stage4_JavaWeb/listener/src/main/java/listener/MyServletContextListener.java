package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 10:44
 * @description:
 * 当一个类实现了ServletContextListener，它就是个监听器
 * 该类可以监听的事件 由该类实现的监听接口决定
 * 该类可以监听ServletContext对象的创建和销毁
 *
 * MyServletContextListener就是一个监听者
 * 当web应用启动时，会产生 ServletContextEvent 事件，会调用监听者的对应事件处理方法contextInitialized()
 * 同时传递事件对象 servletContextEvent，程序员根据此事件对象，获取信息，处理业务
 * TomCat如何知道监听器存在？需要再web.xml中配置，一个容器管理所有的监听器，
 **/
public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		//MyServletContextListener监听到org.apache.catalina.core.ApplicationContextFacade@1a37ba64被创建
		System.out.println("MyServletContextListener监听到" +
				servletContext + "被创建");
		//获取ServletContext对象，业务处理

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		//MyServletContextListener监听到org.apache.catalina.core.ApplicationContextFacade@1a37ba64被销毁
		System.out.println("MyServletContextListener监听到" +
				servletContext + "被销毁");
		//对 servletContext 数据进行处理，保存网站的访问次数到数据库（持久化）
		//对日志进行管理
	}
}
