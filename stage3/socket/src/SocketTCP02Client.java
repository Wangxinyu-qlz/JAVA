import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SocketTCP02Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		//System.out.println("发送");
		//OutputStream outputStream = socket.getOutputStream();
		//outputStream.write("你好服务器，我是客户端".getBytes());
		//socket.shutdownOutput();//设置结束标记
		//System.out.println("发送完毕");

		System.out.println("接收");
		InputStream inputStream = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int readLength;
		while((readLength = inputStream.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, readLength));
		}
		System.out.println("接受完毕");

		socket.close();
		//outputStream.close();
		inputStream.close();
	}
}
