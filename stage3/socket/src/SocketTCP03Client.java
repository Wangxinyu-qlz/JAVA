import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SocketTCP03Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		System.out.println("发送");
		OutputStream outputStream = socket.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("你好服务器，我是客户端  字符流");
		bufferedWriter.newLine();//设置结束标记  需要对方使用readLine()方法读取数据，否则读取不到
		bufferedWriter.flush();//需要手动刷新，否则数据不会写入数据通道
		socket.shutdownOutput();
		System.out.println("发送完毕");

		System.out.println("接收");
		InputStream inputStreamReader = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamReader));
		String s;
		while((s = bufferedReader.readLine()) != null) {
			System.out.println(s);
		}
//		System.out.println(bufferedReader.readLine());
		System.out.println("接受完毕");

		socket.close();
//		TODO 关闭顺序 后打开的先关闭
		bufferedReader.close();
		bufferedWriter.close();
	}
}
