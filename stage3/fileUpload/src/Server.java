import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Server {
	public static void main(String[] args) throws Exception {
		System.out.println("正在监听");
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();

//		读取数据通道的数据
//		通过Socket得到输入流
		BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
		byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

		String filePath = "C:\\My_Code\\Java\\stage3\\fileUpload\\src\\test(1).jpeg";
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
		bufferedOutputStream.write(bytes);
		bufferedOutputStream.close();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write("服务器收到图片");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		socket.shutdownOutput();

		bufferedWriter.close();

//		关闭相关流
		bufferedInputStream.close();
		socket.close();
		serverSocket.close();
	}
}
