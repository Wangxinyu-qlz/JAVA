package qlz.spring_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 17:43
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private Long id;
	private String name;
	private String pwd;
	private String mobile;
	private String email;
	private Integer gender;
}
