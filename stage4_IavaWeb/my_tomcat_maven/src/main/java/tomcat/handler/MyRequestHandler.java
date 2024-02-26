package tomcat.handler;

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
	public static void main(String[] args) {

	}

	@Override
	public void run() {
		//对客户端/浏览器进行IO编程（交互）
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		try {
			System.out.println("============接收数据===========");
			inputStream = socket.getInputStream();
			//将inputStream->bufferedReader
			bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			String mes = null;
			while ((mes= bufferedReader.readLine()) != null) {
				if (mes.isEmpty()){//如果空了就意味着没有信息了，结束读取
					break;
				}
				System.out.println(mes);
			}

			System.out.println("============返回数据===========");
			outputStream = socket.getOutputStream();
			StringBuilder builder = new StringBuilder();
			builder.append("Http/1.1 200 OK\r\n")
					.append("Content-Type: text/html; charset=utf-8\r\n")
					.append("\r\n");
			outputStream.write(builder.toString().getBytes());
			int i= 0;
			i++;
			outputStream.write(String.valueOf(i).getBytes());//不会累加

			outputStream.flush();

			outputStream.close();
			bufferedReader.close();
			inputStream.close();
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
