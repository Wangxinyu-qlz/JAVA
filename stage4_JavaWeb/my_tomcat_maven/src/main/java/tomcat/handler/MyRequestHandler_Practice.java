package tomcat.handler;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//当做一个线程被调用，所以实现 Runnable 接口
public class MyRequestHandler_Practice implements Runnable{
	//接收 ServerSocket
	private Socket socket = null;

	public MyRequestHandler_Practice(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//接收socket的输入流，并输出
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			String mes = "";
			while ((mes=bufferedReader.readLine())!= null) {
				if(mes.isEmpty()) {
					break;
				}
				System.out.println(mes);
			}

			//接收socket的输出流，并发送给浏览器
			OutputStream outputStream = socket.getOutputStream();
			//StringBuffer是线程安全的，
			//StringBuilder不是线程安全的，但是速度快
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Http/1.1 200 OK\r\n")
					    .append("Content-Type:text/html; charset=utf-8")
						.append("\r\n");
			outputStream.write(stringBuffer.toString().getBytes());

			outputStream.flush();

			outputStream.close();
			bufferedReader.close();
			inputStream.close();
			socket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (socket == null) {
				try {
					socket.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
