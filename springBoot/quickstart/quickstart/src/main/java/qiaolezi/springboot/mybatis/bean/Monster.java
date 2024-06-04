package qiaolezi.springboot.mybatis.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:19
 * @description:
 **/
@Data
public class Monster {
	private Integer id;
	private Integer age;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
	private String email;
	private String name;
	private String gender;
	private Double salary;
}
