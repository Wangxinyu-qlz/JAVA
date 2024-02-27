package tomcat;


import tomcat.handler.MyRequestHandler_Practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TomCatV2_Practice {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		while (!serverSocket.isClosed()) {
			//TODO 位置，接受浏览器的连接后，如果成功，得到accept，即通道
			Socket accept = serverSocket.accept();
			new Thread(new MyRequestHandler_Practice(accept)).start();
		}

		serverSocket.close();
	}
}
