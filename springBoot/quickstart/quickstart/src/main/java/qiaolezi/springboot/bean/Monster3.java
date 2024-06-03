package qiaolezi.springboot.bean;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-03 10:44
 * @description:
 **/
//@ToString
@Data
public class Monster3 {
	private Integer id;
	private String name;
	private Integer age;
	private Boolean isMarried;
	private Date birth;
	private Car car;
}
