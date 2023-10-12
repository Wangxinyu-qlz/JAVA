import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConectClientThread extends Thread {
	private Socket socket;
	private String userId;//链接到服务端的用户ID

	public ServerConectClientThread(Socket socket, String userId) {
		this.socket = socket;
		this.userId = userId;
	}

	@Override
	public void run() {//线程处于运行状态，可以发送/接收消息

		while(true) {
			try {
				System.out.println("服务端和客户端" + userId + "保持通信，读取数据...");
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) objectInputStream.readObject();
				//TODO 处理message
				//根据message的类型，做相应的业务处理
				//客户端请求在线用户列表
				if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
					System.out.println(message.getSender() + "请求在线用户列表");
					//规定：在线用户列表的形式[100 200 紫霞仙子 至尊宝]
					String onlineUsers = ManagerServerConnectClientThread.getOnlineUsers();
					//给客户端返回message，构建一个 Message 对象
					Message message1 = new Message();
					message1.setMesType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
					message1.setContent(onlineUsers);
					message1.setGetter(message.getSender());//设置消息接收者
					//写入到数据通道，返回给客户端
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(message1);

				//	客户端退出
				} else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
					//将该用户对应的线程，从集合中删除
					userId = message.getSender();
					ManagerServerConnectClientThread.removeServerConnectClientThread(userId);
					socket.close();//关闭连接

					System.out.println(userId + "已退出系统");
					//退出循环
					break;
				} else {
					System.out.println("其他消息类型，暂时不做处理");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
