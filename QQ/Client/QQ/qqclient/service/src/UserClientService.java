import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author qiaolezi
 * @version 1.0
 * 完成用户登录验证和注册等功能
 */
public class UserClientService {

	//将User做成一个属性的原因：可能在其他地方使用user信息
	private User user = new User();
	//将Socket做成一个属性的原因：可能在其他地方使用
	private Socket socket;
	//根据userId和password到服务器验证该用户是否合法
	public boolean checkUser(String userId, String password) {
		boolean isLegal = false;
		//创建User对象
		user.setUserId(userId);
		user.setPassword(password);

		try {
			//连接到服务端，发送User对象
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//得到ObjectOutputStream对象
			objectOutputStream.writeObject(user);//发送User对象

			//读取从服务器端回复的Message对象
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			Message message = (Message)objectInputStream.readObject();//转型

			if(message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//登陆成功
				//创建一个线程，持有socket，维护CS的通信 ->创建一个类 ClientConnectServerThread
				ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
				//启动客户端线程
				//TODO 验证设置守护线程 选择退出系统后，Process finished with exit code 0，但是服务器端仍然抛出异常
				// 因为没有给服务器端发送要退出的消息
				//clientConnectServerThread.setDaemon(true);
				clientConnectServerThread.start();
				//为了客户端的扩展，将线程放在集合中管理
				ManagerClientConnectServerThread.addClientConnectServerThead(userId, clientConnectServerThread);
				isLegal = true;//用户合法
			} else {//登陆失败
				//如果登录失败，不能启动和服务器通信的线程，关闭socket
				socket.close();
			}

        } catch (Exception e) {
            e.printStackTrace();
        }

		//TODO 这里不能关闭流，否则出现异常


		return isLegal;
	}

	//向服务器端请求在线用户列表
	public void onlineFriendList() {
		//发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);//设置消息类型
		message.setSender(user.getUserId());//设置消息发送者
		//发送给服务器
		try {
			//得到当前线程的 socket 对应的 ObjectOutputStream 对象
			//太长，在下面分开写
			//ObjectOutputStream objectOutputStream = new ObjectOutputStream(
			//		ManagerClientConnectServerThread.getClientConnectServerThread(user.getUserId()).
			//				getSocket().getOutputStream());
			//从管理线程的集合中得到userId对应的线程
			ClientConnectServerThread clientConnectServerThread =
					ManagerClientConnectServerThread.getClientConnectServerThread(user.getUserId());
			//拿到该线程中的 socket 的 outputStream
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					clientConnectServerThread.getSocket().getOutputStream());
			//发送一个Message对象，向服务端请求在线用户列表
			objectOutputStream.writeObject(message);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		//某个用户给服务器发送退出系统的消息
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(user.getUserId());//务必指明退出系统的用户

		//TODO
		// 如果文件夹的结构是：
		// Client(module)
		//      qqclient(module)
		//      qqcommon(module)
		// 会有有奇怪的bug：
		// 		1.	objectOutputStream.writeObject(message);
		//		2.	System.out.println(user.getUserId() + "已退出系统");
		//		3.	System.exit(0);//结束进程
		// 在1 3中间调用user的方法(getuserId/getpassword)会抛出 EOFException
		// 解决方法是 将文件夹结构改为：
		// Server和Client需要保持一致，qqcommon的内容需要序列化和反序列化
		// Client(module)
		//      QQ(module)
		//          qqclient(module)
		//          qqcommon(module)
		// Server(module)
		//      QQ(module)
		//          qqserver(module)
		//          qqcommon(module)
		//          qqframe(module)
		try {
			//从管理线程的集合中获取当前user对应的线程->socket->outputStream
			ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManagerClientConnectServerThread.
		                    getClientConnectServerThread(user.getUserId()).
		                    getSocket().getOutputStream());

			objectOutputStream.writeObject(message);
			System.out.println(user.getUserId() + "已退出系统");
			System.exit(0);//结束进程
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
