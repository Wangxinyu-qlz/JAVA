import java.io.Serializable;

/**
 * @author qiaolezi
 * @version 1.0
 * 客户端和服务端通信的消息对象
 */
public class Message implements Serializable {
	private static final long serialVersionUID =1L;
	private String sender;//发送方
	private String getter;//接收方
	private String content;//消息内容
	private String sendTime;//发送时间
	private String mesType;//消息类型[可以在接口中定义消息类型]

	//进行扩展，和文件相关的成员
	private byte[] fileBytes;
	private int fileLength = 0;//文件长度
	private String dest;//将文件传输到哪里
	private String src;//源文件路径

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
}
