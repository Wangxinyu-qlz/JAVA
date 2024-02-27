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

	public MyResponse(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}
}
