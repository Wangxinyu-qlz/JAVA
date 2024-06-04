package qiaolezi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 15:41
 * @description:
 **/
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AccessException extends RuntimeException {
	public AccessException() {}

	public AccessException(String message) {
		super(message);
	}
}
