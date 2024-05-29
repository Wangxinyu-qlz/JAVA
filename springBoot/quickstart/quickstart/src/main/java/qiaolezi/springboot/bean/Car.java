package qiaolezi.springboot.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:52
 * @description:
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Car {
	private String name;
	private Double price;
}
