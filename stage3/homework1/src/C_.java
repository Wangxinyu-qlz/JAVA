import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class C_ {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		String str = "q";
		bufferedWriter.write(str);
		bufferedWriter.flush();//手动刷新，否则数据不会保存到通道
		socket.shutdownOutput();//结束标记

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data;
		while((data = bufferedReader.readLine()) != null) {
			System.out.println(data);
		}

		bufferedReader.close();
		bufferedWriter.close();
		socket.close();
	}
}
