import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author qiaolezi
 * @version 1.0
 * UDP 发送端
 */
public class UDPSenderB {
	public static void main(String[] args) throws Exception {
//		1.创建 DatagramSocket对象 准备接收（发送）数据
		DatagramSocket datagramSocket = new DatagramSocket(9998);//也需要一个端口，此处在一台机器上，收发端需要不一样的端口

//		2.将需要发送的数据封装到 DatagramPacket 中
		byte[] bytes = "你好~".getBytes();
//		封装的对象参数列表： [data, 数据长度, 对方的IP, 端口号]
		DatagramPacket datagramPacket =
				new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.102.14.224"), 9999);
		datagramSocket.send(datagramPacket);

		byte[] data = new byte[1024 * 64];
		datagramPacket = new DatagramPacket(data, data.length);
		datagramSocket.receive(datagramPacket);
		int length = datagramPacket.getLength();
		byte[] bytes1 = datagramPacket.getData();
		String s = new String(bytes1, 0, length);
		System.out.println(s);

		datagramSocket.close();
		System.out.println("B退出");
	}
}
