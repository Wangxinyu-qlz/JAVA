package main.myspring;

import main.spring.bean.Monster;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-05 09:28
 * @description: 实现Spring的一个简单容器机制：解析beans.xml文件，生成对象并放入容器中
 **/
public class MyApplicationContext {
	ConcurrentHashMap<String, Object> singletonObject = new ConcurrentHashMap<>();

	//构造器
	//接收一个容器的配置文件
	public MyApplicationContext(String iocBeanXmlPath) throws Exception {
		//1.得到类加载路径
		String path = this.getClass().getResource("/").getPath();
		//System.out.println(path);

		//2.创建SAXReader
		SAXReader saxReader = new SAXReader();
		//3.得到document文档 注意这里的路径拼接
		Document document = saxReader.read(new File(path + iocBeanXmlPath));
		//4.得到rootDocument
		Element rootElement = document.getRootElement();
		//5.得到第一个bean
		Element element = rootElement.elements("bean").get(0);
		//6.得到bean的id、classFullPath
		String id = element.attributeValue("id");
		String classFullPath = element.attributeValue("class");

		List<Element> properties = element.elements("property");
		Integer monsterId = Integer.parseInt(properties.get(0).attributeValue("value"));
		String name = properties.get(1).attributeValue("value");
		String skill = properties.get(2).attributeValue("value");

		//7.创建反射对象
		Class<?> aClass = Class.forName(classFullPath);
		Monster monster01 = (Monster)aClass.newInstance();
		//8.赋值
		monster01.setMonsterId(monsterId);
		monster01.setName(name);
		monster01.setSkill(skill);
		//可以通过反射赋值
		//Method[] declaredMethods = aClass.getDeclaredMethods();
		//for (Method declaredMethod : declaredMethods) {
		//	declaredMethod.invoke();
		//}
		//9.将对象放入singletonObjects容器中
		singletonObject.put(id, monster01);
	}

	public Object getBean(String id) {
		return singletonObject.get(id);
	}
}
