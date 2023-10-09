import jdk.nashorn.internal.runtime.regexp.joni.ast.EncloseNode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 * 服务器
 */
public class S_ {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket accept = serverSocket.accept();

//		数据通道 -> byte[]
		BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
		byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

//		byte[] -> image
		String filePath = "C:\\My_Code\\Java\\stage3\\fileUpload\\src\\test(2).jpeg";
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
		bufferedOutputStream.write(bytes);

		bufferedOutputStream.close();
		bufferedInputStream.close();
		accept.close();
		serverSocket.close();
	}
}
