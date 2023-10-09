import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author qiaolezi
 * @version 1.0
 * UDP 接收端
 */
public class UDPReceiverA {
	public static void main(String[] args) throws Exception {
//		1.创建一个 DatagramSocket 对象，准备在端口 9999 接收数据
		DatagramSocket datagramSocket = new DatagramSocket(9999);
//		2.构建一个 DatagramPacket 对象，准备接收数据
//		UDP一个数据包为64KB
		byte[] buffer = new byte[64 * 1024];
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
//		3.调用接收方法，将通过网络传输的 DatagramPacket 对象，传输到datagramPacket对象
//		TODO 在9999端口等待数据，没有数据会阻塞
		datagramSocket.receive(datagramPacket);

//		4.将datagramPacket 进行拆包，取出数据并显示
		int length = datagramPacket.getLength();//实际接收到的数据长度
		byte[] data = datagramPacket.getData();

		String s = new String(data, 0, length);
		System.out.println(s);

		byte[] bytes = "hello".getBytes();
		datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.102.14.224"), 9998);
		datagramSocket.send(datagramPacket);

//		5.关闭资源
		datagramSocket.close();
		System.out.println("A退出");
	}
}
