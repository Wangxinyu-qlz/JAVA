package tomcat.servlet;

import tomcat.http.MyRequest;
import tomcat.http.MyResponse;
import javax.servlet.ServletConfig;
import java.io.IOException;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 14:55
 * @description:
 * 只保留三个核心的方法
 **/
public interface MyServlet {
	void init(ServletConfig var1) throws Exception;
	void service(MyRequest request, MyResponse response) throws IOException;
	void destroy();
}
