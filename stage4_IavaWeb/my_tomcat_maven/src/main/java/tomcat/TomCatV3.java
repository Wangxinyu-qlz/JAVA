package tomcat;

import javafx.collections.transformation.SortedList;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import tomcat.handler.MyRequestHandler;
import tomcat.servlet.MyHttpServlet;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 18:52
 * @description: 通过XML+反射初始化容器
 * TomCat在这里相当于一个大堂服务员，有客人（前端请求）来就引荐给相关部门处理（线程） -> run()方法
 * TomCat还维护了两个容器，里面放着可访问的类的名称（ServletName），url等（XML.web中的信息），在启动后首先init()加载这些信息
 **/
public class TomCatV3 {
	//使用ConcurrentHashMap构建容器，在MyRequestHandler.java 82行
	// MyHttpServlet myHttpServlet = TomCatV3.servletMapping.get(servletName);
	// 会报空指针异常，这是ConcurrentHashMap抛出的异常，当servletName=null时触发
	//1.存放ServletMapping
	//ConcurrentHashMap  Key:ServletName  Value:对应的实例
	public static final ConcurrentHashMap<String, MyHttpServlet>
			servletMapping = new ConcurrentHashMap<>();

	//2.servletUrlMapping
	//ConcurrentHashMap   Key:url-pattern   Value:ServletName
	public static final ConcurrentHashMap<String, String>
			servletUrlMapping = new ConcurrentHashMap<>();

	public static void main(String[] args) throws IOException {
		TomCatV3 tomCatV3 = new TomCatV3();
		tomCatV3.init();
		//启动TomCatV3容器
		tomCatV3.run();
	}

	//启动TomCatV3容器
	public void run() throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("===========9999端口监听=============");
		while (!serverSocket.isClosed()) {
			Socket accept = serverSocket.accept();
			MyRequestHandler myRequestHandler = new MyRequestHandler(accept);
			new Thread(myRequestHandler).start();
		}
	}

	//直接对两个容器进行初始化，加载信息
	public void init() {
		//读取web.xml文件 => dom4j =>
		//得到web.xml文件的路径 => 拷一份
		String path = TomCatV3.class.getResource("/").getPath();
		//TODO path=/C:/My_Code/Java/stage4_IavaWeb/my_tomcat_maven/target/classes/
		// 注意这里读取的是target目录下的文件，如果在src/main/webapp/WEB-INF/web.xml中更新了内容，一定要拷贝一份
		//System.out.println("path=" + path);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File(path + "web.xml"));
			//System.out.println("document=" + document);
			//得到根元素
			Element rootElement = document.getRootElement();
			//得到根元素下面的所有元素
			List<Element> elements = rootElement.elements();
			//遍历并过滤得到servlet servlet-mapping
			for (Element element : elements) {
				if("servlet".equalsIgnoreCase(element.getName())) {
					//servlet配置
					//使用反射将servlet实例放入servletMapping
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					//TODO 通过getText拿到内容  trim()方法去掉字符串两端的空格
					servletMapping.put(servletName.getText(),
							(MyHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
				} else if ("servlet-mapping".equalsIgnoreCase(element.getName())) {
					//servlet-mapping配置
					Element servletName = element.element("servlet-name");
					Element urlPattern = element.element("url-pattern");
					servletUrlMapping.put(urlPattern.getText(), servletName.getText());
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		////验证容器是否初始化成功
		//System.out.println("servletMapping=" + servletUrlMapping);
		//System.out.println("servletUrlMapping=" + servletUrlMapping);
	}
}
