import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

		String filePath = "C:\\My_Code\\Java\\stage3\\fileUpload\\src\\test.jpeg";
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
//		文件内容
		byte[] image = StreamUtils.streamToByteArray(bufferedInputStream);

		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

		bufferedOutputStream.write(image);//将文件对应的字节数组，写入到数据通道
		socket.shutdownOutput();//设置数据结束标记

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String s;
		while((s = bufferedReader.readLine()) != null) {
			System.out.print(s);
		}
		bufferedReader.close();
		bufferedInputStream.close();


//		关闭相关流
		bufferedOutputStream.close();
		socket.close();
	}
}
