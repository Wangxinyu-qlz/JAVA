import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 * 服务端
 */
public class SocketTCP01Server {
	public static void main(String[] args) throws IOException {
//		思路：
//		1.在本机的 9999 端口监听，等待连接
//		细节：要求在本机没有其他服务占用 9999 端口
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务端在 9999 端口监听，等待连接");
//		2.当没有客户端连接 9999 端口时，程序会阻塞，等待连接
//		如果有客户端连接，返回Socket对象，程序继续
//		TODO ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
		Socket socket = serverSocket.accept();
		System.out.println("服务器端 socket=" + socket.getClass());
//		3.通过socket.getInputStream() 读取客户端写入到数据通道的数据，显示
		InputStream inputStream = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int readLength = 0;
		while((readLength = inputStream.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, readLength));//根据读取到的长度显示字符串
		}

//		4.关闭流和socket
		inputStream.close();
		socket.close();
		serverSocket.close();
	}
}
