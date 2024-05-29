package qiaolezi.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:07
 * @description:
 **/
@Component  //启用@EnableConfigurationProperties(Furn.class)要注释掉这里
@ConfigurationProperties(prefix = "furn01")
@ToString
@Data//setter getter
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
public class Furn {
	private Integer id;
	private String name;
	private Double price;
}
