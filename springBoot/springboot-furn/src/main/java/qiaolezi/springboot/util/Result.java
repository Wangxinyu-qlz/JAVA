package qiaolezi.springboot.util;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:46
 * @description:
 **/
public class Result<T> {
	private String code;
	private String message;
	private T data;

	public String getCode() {
		return code;

	}

	public void setCode(String code) {
		this.code = code;

	}

	public String getMessage() {
		return message;

	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Result() {
	}

	public Result(T data) {
		this.data = data;
	}

	public static Result success() {
		Result result = new Result<>();
		result.setCode("200");
		result.setMessage("success");
		return result;
	}

	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<>(data);
		result.setCode("200");
		result.setMessage("success");
		return result;
	}

	public static Result error(String code, String message) {
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}

	//增加一个方法
	public static <T> Result<T> error(String code, String message, T data) {
		Result<T> result = new Result<>(data);
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
}