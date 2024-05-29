package qiaolezi.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 23:02
 * @description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Component
//将yaml文件引入
@ConfigurationProperties(prefix = "monster")
public class Monster2 {
	private Integer id;
	private String name;
	private Integer age;
	private Boolean isMarried;
	private Date birth;
	private Car car;
	private String[] skill;
	private List<String> hobby;
	private Map<String, Object> wife;
	private Set<Double> salaries;
	private Map<String, List<Car>> cars;
}
