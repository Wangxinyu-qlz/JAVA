package tomcat;

import tomcat.handler.MyRequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TomCatV2 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("============监听===========");

		//只要serverSocket没有关闭，就一直等待
		while (!serverSocket.isClosed()) {
			//接受浏览器的连接后，如果成功，得到socket，即通道
			Socket accept = serverSocket.accept();
			//创建一个线程对象，将 socket 给该线程
			//TODO 创建一个 实现了Runnable()接口的类的 对象，将其丢进 创建的Thread()对象
			MyRequestHandler myRequestHandler = new MyRequestHandler(accept);
			new Thread(myRequestHandler).start();
		}

		serverSocket.close();
	}
}
