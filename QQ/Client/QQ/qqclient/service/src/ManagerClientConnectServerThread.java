import java.util.HashMap;

/**
 * @author qiaolezi
 * @version 1.0
 * 该类管理客户端到服务器端的线程的类
 */
public class ManagerClientConnectServerThread {
	// 将多个线程放进HashMap集合中，key为 userID，value为线程
	private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

	//将某个线程加入到集合中
	public static void addClientConnectServerThead(String userId, ClientConnectServerThread clientConnectServerThread) {
		hm.put(userId, clientConnectServerThread);
	}

	// 得到 userId 对应的线程
	public static ClientConnectServerThread getClientConnectServerThread(String userId) {
		return hm.get(userId);
	}
}
