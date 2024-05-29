package qiaolezi.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 22:07
 * @description:
 **/
//@Component  //启用@EnableConfigurationProperties(Furn.class)要注释掉这里
@ConfigurationProperties(prefix = "furn01")
public class Furn {
	private Integer id;
	private String name;
	private Double price;

	public Integer getId() {
		return id;

	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public Double getPrice() {
		return price;

	}

	public void setPrice(Double price) {
		this.price = price;

	}

}

