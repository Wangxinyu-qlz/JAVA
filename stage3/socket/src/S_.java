import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class S_ {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int readLength = 0;
		while((readLength = inputStream.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, readLength));
		}

		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("字节流  你好，我是服务器！".getBytes());
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("字符流  重复，这里是服务器~");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		socket.shutdownOutput();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String str;
		while((str = bufferedReader.readLine()) != null) {
			System.out.println(str);
		}

		bufferedWriter.close();
		bufferedReader.close();

		outputStream.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
	}
}
