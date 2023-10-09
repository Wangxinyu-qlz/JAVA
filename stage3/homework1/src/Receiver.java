import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Receiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(9999);
		byte[] buffer = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
		datagramSocket.receive(datagramPacket);

		byte[] data = datagramPacket.getData();
		int length = datagramPacket.getLength();
		String s = new String(data, 0, length);
		System.out.println(s);

		String reply;
		if(s.equals("四大名著是哪些？")) {
			reply = "四大名著是...";
		} else {
			reply = "啥？";
		}

		datagramPacket =
				new DatagramPacket(reply.getBytes(), reply.getBytes().length, InetAddress.getByName("10.102.14.224"), 9998);
		datagramSocket.send(datagramPacket);

		datagramSocket.close();
	}
}
