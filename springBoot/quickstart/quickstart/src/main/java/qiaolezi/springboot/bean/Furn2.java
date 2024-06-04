package qiaolezi.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 20:18
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furn2 {
	private Integer id;
	private String name;
	private String maker;
	private BigDecimal price;
	private Integer sales;
	private Integer stock;
	private String imgPath = "assets/images/product-image/1.jpg";
}
