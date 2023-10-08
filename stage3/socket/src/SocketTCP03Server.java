import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SocketTCP03Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		System.out.println("接收");
		InputStream inputStreamReader = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamReader));
		String s;
		while((s = bufferedReader.readLine()) != null) {
			System.out.println(s);
		}
//		System.out.println(bufferedReader.readLine());
		System.out.println("接收完毕");

		System.out.println("发送");
		OutputStream outputStream = socket.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("你好客户端，我是服务器  字符流");
		bufferedWriter.newLine();//TODO 要求对象使用readLine()方法读取数据，否则读取不到
		bufferedWriter.flush();//需要手动刷新，否则不会写入数据通道
		socket.shutdownOutput();//TODO 如果使用while接收数据，需要使用此方法，否则会阻塞
		System.out.println("发送完毕");

		serverSocket.close();
		socket.close();
//		后打开的先关闭
		bufferedWriter.close();
		bufferedReader.close();
	}
}
