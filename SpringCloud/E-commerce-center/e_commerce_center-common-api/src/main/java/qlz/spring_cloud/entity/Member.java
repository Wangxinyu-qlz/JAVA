package qlz.spring_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-06 09:33
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
	private Long id;
	private String name;
	private String pwd;
	private String mobile;
	private String email;
	private Integer gender;
}
