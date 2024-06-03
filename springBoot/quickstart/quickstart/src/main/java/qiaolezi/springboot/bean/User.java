package qiaolezi.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 15:26
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private String email;

}
