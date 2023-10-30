import java.io.*;

/**
 * @author qiaolezi
 * @version 1.0
 * 该类/对象 完成文件传输服务
 */
public class FileClientService {
	/**
	 *
	 * @param src 源文件
	 * @param dest 文件传输到哪里
	 * @param senderId 发送者ID
	 * @param getterId 接收者ID
	 */
	public void sendFileToOne(String src, String dest, String senderId, String getterId) {
		//读取src文件  --> message
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_FILE_MES);
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setSrc(src);
		message.setDest(dest);

		//将文件读取
		FileInputStream fileInputStream = null;
		byte[] fileBytes = new byte[(int) new File(src).length()];

		try {
			fileInputStream = new FileInputStream(src);
			fileInputStream.read(fileBytes);//将src文件读入到程序的字节数组
			//将文件对应的字节数组 设置 message 对象
			message.setFileBytes(fileBytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//提示信息
		System.out.println("\n" + senderId + "发送文件" + src + "给" + getterId + "到对方的电脑目录：" + "dest");

		//发送
		try {
			ObjectOutputStream objectOutputStream =
					new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThread(senderId).
							getSocket().getOutputStream());
			objectOutputStream.writeObject(message);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
