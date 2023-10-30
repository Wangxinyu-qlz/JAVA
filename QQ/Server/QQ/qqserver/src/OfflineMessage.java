import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class OfflineMessage {
	private static ConcurrentHashMap<String, ArrayList<Message>> offlineMessages = new ConcurrentHashMap<>();


    //保存离线用户的message
    public static void saveOfflineMessage(String offlineUserId, Message message) {
        if (offlineMessages.containsKey(offlineUserId)) {//TODO 如果已经有这个离线用户了，只更改他收到的离线消息
            offlineMessages.get(offlineUserId).add(message);
        } else {
			ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            offlineMessages.put(offlineUserId, messages);
        }
    }

	//处理其他用户给该用户的离线留言
	public static void SendOfflineMessage(String userId) {
		for (String getterId : offlineMessages.keySet()) {//遍历map查看是否有此用户的离线消息
			if (getterId.equals(userId)) {
				ArrayList<Message> messages = offlineMessages.get(userId);
				for (Object oneMessage : messages) {//遍历所有离线消息并逐一发送
					try {
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManagerServerConnectClientThread.
								getServerConnectClientThread(userId).getSocket().getOutputStream());
						objectOutputStream.writeObject(oneMessage);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
				//TODO 删除该用户的离线留言记录
				offlineMessages.remove(userId);
			}
		}
	}

    public static ConcurrentHashMap<String, ArrayList<Message>> getOfflineMessages() {
        return offlineMessages;
    }

}
