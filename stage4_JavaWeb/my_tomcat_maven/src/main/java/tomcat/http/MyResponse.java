package tomcat.http;

import java.io.OutputStream;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-27 14:59
 * @description:
 **/
public class MyResponse {
	private OutputStream outputStream = null;
	//HTTP响应头
	public static final String responseHeader = "Http/1.1 200 OK\r\n" +
					"Content-Type: text/html; charset=utf-8\r\n" +
					"\r\n";

	//setContentType()方法
	public MyResponse(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}
}
