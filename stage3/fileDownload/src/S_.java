import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class S_ {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		String filePath;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		filePath = bufferedReader.readLine();

		File file = new File(filePath);

		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
//		file -> byte[]
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
//		数据写入通道
			bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
			bufferedOutputStream.write(bytes);
		} catch (Exception e) {//如果文件不存在
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("您要下载的文件不存在！");
			bufferedWriter.flush();
			socket.shutdownOutput();
		} finally {
			if (bufferedOutputStream != null) {
				bufferedOutputStream.close();
			}
			if (bufferedInputStream != null) {
				bufferedInputStream.close();
			}
		}

		bufferedReader.close();
		socket.close();
		serverSocket.close();
	}
}
