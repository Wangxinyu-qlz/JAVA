import java.util.HashMap;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 * 该类用于管理和客户端通信的线程
 */
public class ManagerServerConnectClientThread {
	private static HashMap<String, ServerConectClientThread> hm = new HashMap<>();

	//添加线程对象到集合
	public static void addServerConnectClientThread(String userId, ServerConectClientThread serverConectClientThread) {
		hm.put(userId, serverConectClientThread);
	}

	public static void removeServerConnectClientThread(String userId) {
		hm.remove(userId);
	}

	//得到某个用户对应的线程
	public static ServerConectClientThread getServerConnectClientThread(String userId) {
		return hm.get(userId);
	}

	//返回在线用户列表
	public static String getOnlineUsers() {
		//集合遍历，key
		Iterator<String> iterator = hm.keySet().iterator();
		String onlineUsersList = "";
		while(iterator.hasNext()) {
			onlineUsersList += iterator.next().toString() + " ";
		}

		return onlineUsersList;
	}
}
