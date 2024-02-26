package tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * TomCat V1.0
 * 功能：接受浏览器的请求，返回信息
 */
public class TomCatV1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		while (!serverSocket.isClosed()) {
			Socket accept = serverSocket.accept();
			InputStream inputStream = accept.getInputStream();//字节流
			//-->字符流
			BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			String mes = null;
			//接收到浏览器发送的数据
			while ((mes = bufferedReader.readLine()) != null){
				if (mes.isEmpty()) {
					break;
				}
				System.out.println(mes);
			}

			OutputStream outputStream = accept.getOutputStream();
			String builder = "Http/1.1 200 OK\r\n" +
							//Content-Type  不是Content Type
							"Content-Type:text/html; charset=utf-8\r\n" +
							"\r\n";//必须要有
			outputStream.write(builder.getBytes());
			outputStream.write("<h1>你好啊，hello，123</h1>".getBytes());

			outputStream.flush();
			outputStream.close();
			accept.close();
		}
		serverSocket.close();
	}
}
