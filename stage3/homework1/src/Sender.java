import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Sender {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(9998);
		String data = "四大名著是哪些？";
		byte[] bytes = data.getBytes();
		DatagramPacket datagramPacket
				= new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.102.14.224"), 9999);
		datagramSocket.send(datagramPacket);

		byte[] buffer = new byte[1024 * 64];
		datagramPacket = new DatagramPacket(buffer, buffer.length);
		datagramSocket.receive(datagramPacket);
		byte[] receivedReply = datagramPacket.getData();
		int length = datagramPacket.getLength();
		String s = new String(receivedReply, 0, length);
		System.out.println(s);

		datagramSocket.close();
	}
}
