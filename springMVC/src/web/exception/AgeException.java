package web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-29 21:49
 * @description:
 **/
@ResponseStatus(reason = "年龄需要在1-150之间", value = HttpStatus.BAD_REQUEST)
public class AgeException extends RuntimeException{
	public AgeException() {}
	
	public AgeException(String message) {
		super(message);
	}
}
