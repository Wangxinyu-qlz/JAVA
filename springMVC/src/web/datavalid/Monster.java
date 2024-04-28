package web.datavalid;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: springMVC
 * @author: Qiaolezi
 * @create: 2024-04-28 16:14
 * @description:
 **/
public class Monster {
	@NotNull()
	//id: 前端国际化 不生效
	private Integer id;//String -> Integer

	//取消绑定->不能使用验证的注解
	@NotEmpty
	private String name;

	@NotNull(message = "不能为空")
	@Range(min = 0, max = 150)
	private Integer age;

	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NumberFormat(pattern = "###,###.##")
	private Float salary;

	public Monster() {
	}

	public Monster(Integer id, String name, Integer age, String email, Date birthday, Float salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.birthday = birthday;
		this.salary = salary;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Monster{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", birthday=" + birthday +
				", salary=" + salary +
				'}';
	}
}
