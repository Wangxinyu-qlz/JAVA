package qiaolezi.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 16:32
 * @description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Monster {
	private Integer id;
	private String name;
	private Integer age;
	private String skill;
}
