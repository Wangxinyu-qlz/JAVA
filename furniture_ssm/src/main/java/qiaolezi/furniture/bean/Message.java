package qiaolezi.furniture.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-28 16:07
 * @description:
 **/
public class Message {
	//状态码 200 成功 400失败
	private int code;
	private String message;
	private Map<String, Object> extend = new HashMap<>();

	public static Message success(){
		Message message = new Message();
		message.setCode(200);
		message.setMessage("success");
		return message;
	}

	public static Message fail(){
		Message message = new Message();
		message.setCode(400);
		message.setMessage("fail");
		return message;
	}

	public Message add(String key, Object value){
		this.getExtend().put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
}
