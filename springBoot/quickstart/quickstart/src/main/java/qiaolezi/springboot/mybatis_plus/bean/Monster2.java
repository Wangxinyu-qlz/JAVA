package qiaolezi.springboot.mybatis_plus.bean;

import com.baomidou.mybatisplus.annotation.TableName;
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
//如果数据库名称和Bean名称不一致，可以配置一个映射
@TableName("monster")
public class Monster2 {
	private Integer id;
	private Integer age;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
	private String email;
	private String name;
	private String gender;
	private Double salary;
}
