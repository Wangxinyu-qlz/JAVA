import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Java
 * @description: 创建自己的TomCat
 * @author: Qiaolezi
 * @create: 2024-02-20 21:04
 **/
public class MyTomcat {
	public static void main(String[] args) throws IOException {
		//1.在??端口监听
		//TODO 用浏览器访问，只能用80端口。否则：localhost 发送的响应无效。ERR_INVALID_HTTP_RESPONSE
		// 原因：浏览器无法识别响应头
		// 解决方法：手动做一个响应头
		// http请求是80 https是443
		ServerSocket serverSocket = new ServerSocket(9999);
		//serverSocket.bind(new InetSocketAddress(9999));//创建服务器套接字并绑定到本地主机的9999端口上
		//如果serverSocket 没有关闭，就等待连接, 不停的等待
		while (!serverSocket.isClosed()) {
			System.out.println("=====我的web 服务在80 端口监听=====");
			//2. 等待浏览器/客户端连接, 得到socket
			// 该socket 用于通信
			Socket socket = serverSocket.accept();

			//测试
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];//数据缓冲区
			int len = 0;
			String s = "";
			//从输入流中读取字节并转换为字符串打印出来
			//inputStream.read(bytes)  将读取到的数据存储到bytes数组中，如果bytes的长度是0，不会读取。
			//返回 实际读取到的数据的长度
			if ((len = inputStream.read(bytes)) > 0) {
				s = new String(bytes, 0, len);
			}
			System.out.println("s = " + s);
			//inputStream.available();

			//3. 通过socket 得到 输出流，[]
			OutputStream outputStream = socket.getOutputStream();

			//显式的做一个请求头
			StringBuilder builder = new StringBuilder();
			//    HTTP/1.1 200 OK\n
			//    Content-Type: text/html\n
			//    \r\n
			StringBuilder resStr = builder
					.append("HTTP/1.1 200 OK\n")
					.append("Content-Type: text/html\n")
					.append("\r\n");
			outputStream.write(resStr.toString().getBytes());

			//4. 读取 hello.html 文件返回即可=> 如何读取文件内容
			// 得到文件输入流(字符输入流), 和 src/hello.html
			// 返回给浏览器/客户端
			BufferedReader bufferedReader =
			new BufferedReader(new FileReader("C:\\My_Code\\Java\\stage4_JavaWeb" +
					"\\tomcat\\src\\hello.html"));
			String buf = "";
			// 循环读取hello.html
			while ((buf = bufferedReader.readLine()) != null) {
				outputStream.write(buf.getBytes());
			}

			outputStream.flush();
			outputStream.close();
			socket.close();
		}
		serverSocket.close();
	}
}
