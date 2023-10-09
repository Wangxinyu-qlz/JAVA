import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class C_ {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("字节流  你好，我是客户端~".getBytes());
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("字符流  重复，这里是客户端");
		bufferedWriter.newLine();//数据结束标记
		bufferedWriter.flush();//手动刷新，否则数据不会写入
		socket.shutdownOutput();//数据结束标志

		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int readLength = 0;
		while((readLength = inputStream.read(bytes)) != -1) {
			System.out.println(new String(bytes, 0, readLength));
		}


		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String str;
		while((str = bufferedReader.readLine()) != null) {
			System.out.println("test");
			System.out.println(str);
		}

//		TODO 关闭buffered
		bufferedReader.close();
		bufferedWriter.close();

		inputStream.close();
		outputStream.close();
		socket.close();
	}
}
