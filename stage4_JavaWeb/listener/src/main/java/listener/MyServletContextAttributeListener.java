package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 11:14
 * @description:
 **/
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyServletContextAttributeListener监听到添加属性" + name + " " + value);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyServletContextAttributeListener监听到删除属性" + name + " " + value);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyServletContextAttributeListener监听到替换属性" + name + " " + value);
	}
}
