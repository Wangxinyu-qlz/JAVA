package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 11:50
 * @description:
 **/
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyHttpSessionAttributeListener监听到添加属性" + name + " " + value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyHttpSessionAttributeListener监听到删除属性" + name + " " + value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("MyHttpSessionAttributeListener监听到修改属性" + name + " " + value);
	}
}
