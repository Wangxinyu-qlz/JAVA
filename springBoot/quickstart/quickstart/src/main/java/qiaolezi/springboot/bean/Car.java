package qiaolezi.springboot.bean;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:52
 * @description:
 **/
//@Data : All together now: A shortcut for @ToString, @EqualsAndHashCode,
// @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor!
@Data
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Car {
	private String name;
	private Double price;
}
