import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author qiaolezi
 * @version 1.0
 * 该类提供和消息相关的服务方法
 */
public class MessageClientService {
	/**
	 *
	 * @param senderId 消息发送者
	 * @param getterId 消息接收者
	 * @param content 消息内容
	 */
	public void sendMessageToOne(String senderId, String getterId, String content) {
		Message message = new Message();
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setContent(content);
		String sendTime = new Date().toString();
		message.setSendTime(sendTime);//发送时间
		System.out.println(senderId + " 对 " + getterId + " 说：" + content + "(" + sendTime + ")");

		try {
			//发送给服务端
			ObjectOutputStream objectOutputStream =
					new ObjectOutputStream(ManagerClientConnectServerThread.
							getClientConnectServerThread(senderId).
							getSocket().getOutputStream());
			objectOutputStream.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
