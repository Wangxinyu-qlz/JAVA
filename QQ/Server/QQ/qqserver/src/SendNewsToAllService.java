import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class SendNewsToAllService implements Runnable {
	@Override
	public void run() {
		//为了多次推送消息，使用while(true)
		while (true) {
			System.out.println("请输入要推送的新闻/消息[输入exit退出推送服务]：");
			String news = Utility.readString(100);
			if(news.equals("exit")) {
				System.out.println("您已退出新闻/消息推送服务~");
				break;
			}
			Message message = new Message();
			message.setSender("服务器");
			message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
			message.setContent(news);
			message.setSendTime(new Date().toString());
			System.out.println("服务器推送：" + news);

			//遍历所有的通信线程，得到socket，并转发message对象
			HashMap<String, ServerConectClientThread> hm = ManagerServerConnectClientThread.getHm();

			Iterator<String> iterator = hm.keySet().iterator();
			while(iterator.hasNext()) {
				String onlineUserId = iterator.next();
				ServerConectClientThread serverConectClientThread = hm.get(onlineUserId);
				try {
					ObjectOutputStream objectOutputStream =
							new ObjectOutputStream(serverConectClientThread.getSocket().getOutputStream());
					objectOutputStream.writeObject(message);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

}
