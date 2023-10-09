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

//		发送要下载的文件地址
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String filePath = "C:\\My_Code\\Java\\stage3\\fileDownload\\src\\test.jpeg";
		bufferedWriter.write(filePath);
		bufferedWriter.flush();
		socket.shutdownOutput();

		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String s = bufferedReader.readLine();
		if (s.equals("您要下载的文件不存在！")) {
			System.out.println(s);
		} else {
			String fileToSave = "C:\\My_Code\\Java\\stage3\\fileDownload\\src\\test(1).jpeg";
			bufferedInputStream = new BufferedInputStream(socket.getInputStream());
			byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileToSave));
			bufferedOutputStream.write(bytes);
			System.out.println("已成功将文件下载到本地");
		}

		if (bufferedOutputStream != null) {
			bufferedOutputStream.close();
		}
		if (bufferedInputStream != null) {
			bufferedInputStream.close();
		}

		bufferedReader.close();
		bufferedWriter.close();
		socket.close();
	}
}
