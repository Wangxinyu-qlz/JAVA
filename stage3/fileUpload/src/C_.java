import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 * 客户端
 */
public class C_ {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

//		image -> byte[]
		String filePath = "C:\\My_Code\\Java\\stage3\\fileUpload\\src\\test.jpeg";
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
		byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

//		byte[] -> 数据通道
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
		bufferedOutputStream.write(bytes);

//		close
		bufferedOutputStream.close();
		bufferedInputStream.close();
		socket.close();

	}
}
