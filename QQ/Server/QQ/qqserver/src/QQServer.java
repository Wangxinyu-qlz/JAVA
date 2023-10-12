import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiaolezi
 * @version 1.0
 * 服务器，监听 9999 端口，等待客户端的链接并保持通讯
 */
public class QQServer {
	private ServerSocket serverSocket = null;
	//创建一个集合（HashMap），存放多个用户。如果这些用户登录，就认为是合法的
	//这里也可以使用 ConcurrentHashMap，可以处理并发的集合，没有线程安全问题
	//HashMap没有处理线程安全，在多线程情况下不安全
	//ConcurrentHashMap是线程安全的，即线程同步处理
	private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

	static{//在静态代码块初始化 validUsers
		validUsers.put("100", new User("100", "123456"));
		validUsers.put("200", new User("200", "123456"));
		validUsers.put("300", new User("300", "123456"));
		validUsers.put("至尊宝", new User("至尊宝", "123456"));
		validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
	}

	private boolean checkUser(String userId, String password) {
		User user = validUsers.get(userId);
		//过关斩将验证法
		if(user == null) {//说明没有这个用户
			return false;
		}
		if(!user.getPassword().equals(password)) {//密码错误
			return false;
		}
		return true;
	}

	public QQServer() {
		// 端口可以写在一个配置文件中
		try {
			System.out.println("服务器在9999端口监听...");
			serverSocket = new ServerSocket(9999);

			while(true) {//一致保持监听：和某个客户端建立链接后，继续监听
				//如果没有客户端连接，会在这里阻塞
				Socket socket = serverSocket.accept();
				// socket关联的对象输入流
				ObjectInputStream objectInputStream =
						new ObjectInputStream(socket.getInputStream());
				// socket关联的对象输出流
				ObjectOutputStream objectOutputStream =
						new ObjectOutputStream(socket.getOutputStream());
				User user = (User)objectInputStream.readObject();//读取客户端发送的User对象
				// 创建一个Message对象，回复客户端
				Message message = new Message();
				// 验证用户信息
				if(checkUser(user.getUserId(), user.getPassword())) {//合法->登陆成功
					message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
					//将message对象回复给客户端
					objectOutputStream.writeObject(message);
					//创建一个线程，和客户端保持通信，该线程需要持有socket对象
					ServerConectClientThread serverConectClientThread =
							new ServerConectClientThread(socket, user.getUserId());
					serverConectClientThread.start();
					//将该线程对象放入HashMap中进行管理
					ManagerServerConnectClientThread.addServerConnectClientThread(
							user.getUserId(), serverConectClientThread);
				} else {//非法->登陆失败
					System.out.println("用户id=" + user.getUserId() + "，用户密码=" + user.getPassword() + "验证失败");
					message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
					//将message对象回复给客户端
					objectOutputStream.writeObject(message);
					socket.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//如果服务器退出了while，说明服务器不在监听，关闭serverSocket
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
