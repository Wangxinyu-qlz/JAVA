package qiaolezi.springboot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:22
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furn {
	@TableId(type = IdType.AUTO)
	private Integer id;
	@NotEmpty(message = "请输入家具名")
	private String name;
	@NotEmpty(message = "请输入厂商名")
	private String maker;
	@NotNull(message = "请输入数字")
	@Range(min = 0, message = "价格不能小于0")
	private BigDecimal price;
	@NotNull(message = "请输入数字")
	@Range(min = 0, message = "销量不能小于0")
	private Integer sales;
	@NotNull(message = "请输入数字")
	@Range(min = 0, message = "库存不能小于0")
	private Integer stock;
}
