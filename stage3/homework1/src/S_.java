
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class S_ {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket accept = serverSocket.accept();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
		String buffer = bufferedReader.readLine();

		System.out.println(buffer);
		String reply;
		switch(buffer) {
			case "name":
				reply = "I'm nova.";
				break;
			case "hobby":
				reply = "program in JAVA.";
				break;
			default:
				reply = "what?";
				break;
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
		bufferedWriter.write(reply);
		bufferedWriter.flush();
		accept.shutdownOutput();

		bufferedWriter.close();
		bufferedReader.close();
		accept.close();
		serverSocket.close();
	}
}
