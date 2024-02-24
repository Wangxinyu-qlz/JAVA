package servlet.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * @program: Java
 * @description: 测试tomcat通过直接装载Servlet
 * @author: Qiaolezi
 * @create: 2024-02-24 15:22
 **/
public class TestAnnotationServlet {
	private static final HashMap<String, HttpServlet> hm = new HashMap<>();
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//1.得到扫描的包 路径 io，得到类的  全路径
		String classAllPath = "servlet.annotation.OkServlet";
		//2.得到 OkServlet 的 Class 对象
		Class<?> aClass = Class.forName(classAllPath);
		//3.通过class对象，得到annotation
		WebServlet annotation = aClass.getAnnotation(WebServlet.class);
		System.out.println(annotation);
		String[] strings = annotation.urlPatterns();
		for (String url : strings) {
			System.out.println("url:" + url);
		}

		//如果匹配了url，如果是第一次，tomcat 会创建一个OkServlet的实例，放入到hashmap
		Object instance = aClass.newInstance();
		System.out.println("instance=" + instance);//OkServlet实例  instance=servlet.annotation.OkServlet@2626b418
		hm.put("OkServlet", (HttpServlet) instance);

		System.out.println(hm);//{OkServlet=servlet.annotation.OkServlet@2626b418}
	}
}
