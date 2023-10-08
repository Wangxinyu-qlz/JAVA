import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SocketTCP02Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		System.out.println("接收");
		InputStream inputStream = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int readLength = 0;
		while((readLength = inputStream.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, readLength));
		}
		System.out.println("接收完毕");

		System.out.println("发送");
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("你好客户端，我是服务器".getBytes());
		socket.shutdownOutput();
		System.out.println("发送完毕");

		serverSocket.close();
		socket.close();
		inputStream.close();
		outputStream.close();
	}
}
