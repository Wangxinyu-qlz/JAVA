package tomcat.handler;

import tomcat.TomCatV3;
import tomcat.http.MyRequest;
import tomcat.http.MyResponse;
import tomcat.servlet.MyCalculateServlet;
import tomcat.servlet.MyHttpServlet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 该对象是一个线程对象
 * 处理Http请求
 * 必须持有Socket
 */
public class MyRequestHandler implements Runnable {
	private Socket socket = null;
	//构造器
	public MyRequestHandler(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		//对客户端/浏览器进行IO编程（交互）
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		try {
			//System.out.println("============myRequestHandler接收数据===========");
			//将inputStream->bufferedReader
			//bufferedReader = new BufferedReader(
			//		new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			//String mes = null;
			//while ((mes= bufferedReader.readLine()) != null) {
			//	if (mes.isEmpty()){//如果空了就意味着没有信息了，结束读取
			//		break;
			//	}
			//	System.out.println(mes);
			//}

			MyRequest myRequest = new MyRequest(socket.getInputStream());
			//String method = myRequest.getMethod();
			//System.out.println("method=" + method);
			//String uri = myRequest.getUri();
			//System.out.println("uti=" + uri);
			//String num1 = myRequest.getParameter("num1");
			//String num2 = myRequest.getParameter("num2");
			//String name = myRequest.getParameter("name");
			//System.out.println("请求的参数：num1=" + num1 + " num2=" + num2 + " name=" + name);
			//System.out.println("MyRequest=" + myRequest);

			//System.out.println("============myRequestHandler返回数据===========");
			//outputStream = socket.getOutputStream();
			//StringBuilder builder = new StringBuilder();
			//builder.append("Http/1.1 200 OK\r\n")
			//		.append("Content-Type: text/html; charset=utf-8\r\n")
			//		.append("\r\n");
			//outputStream.write(builder.toString().getBytes());
			//int i= 0;
			//i++;
			//outputStream.write(String.valueOf(i).getBytes());//不会累加

			//这个Response对象可以床底给Servlet，在其中的doPost()和doGet()方法中处理
			MyResponse myResponse = new MyResponse(socket.getOutputStream());
			//String responseMes = MyResponse.responseHeader + "你好";
			//outputStream = myResponse.getOutputStream();
			//outputStream.write(responseMes.getBytes());

			//TODO 这里是写死的，如果有多个Servlet，这样写需要改底层代码。需要用xml/注解（反射）构建对象
			//MyCalculateServlet应该在哪里实例化？如何管理？
			//MyCalculateServlet myCalculateServlet = new MyCalculateServlet();//硬编码
			//myCalculateServlet.doGet(myRequest, myResponse);

			//软编码：
			// 1.uri:servletMapping的url-pattern -> servletName
			String uri = myRequest.getUri();
			String servletName = TomCatV3.servletUrlMapping.get(uri);
			//解决空指针异常
			if(servletName==null){
				servletName = "";
			}
			// 2.servletName -> Servlet实例，真正的运行类型是其子类：MyCalculateServlet（可以使其他的任何子类）
			MyHttpServlet myHttpServlet = TomCatV3.servletMapping.get(servletName);
			//TODO 这里调用 service() 方法 -> 动态绑定 this.doGet(request, response);
			/*
			*   @Override
				public void service(MyRequest request, MyResponse response) throws IOException {
					if("GET".equalsIgnoreCase(request.getMethod())) {
						this.doGet(request, response);
					} else if ("POST".equalsIgnoreCase(request.getMethod())) {
						this.doPost(request, response);
					}
				}
			* */
			if (myHttpServlet != null) {//如果得到了，uri是正确的
				myHttpServlet.service(myRequest, myResponse);
			} else {
				//没有这个servlet，返回404 NOT FOUND
				String response404 = MyResponse.responseHeader + "<h1>404 NOT FOUNT!</h1>";
				OutputStream outputStream404 = myResponse.getOutputStream();
				outputStream404.write(response404.getBytes());
			}


			//outputStream.flush();
			//outputStream.close();
			//bufferedReader.close();//此处会引发前端请求时后端抛出空指针异常
			//inputStream.close();
			socket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			//TODO 一定要确保关掉socket！！！
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
