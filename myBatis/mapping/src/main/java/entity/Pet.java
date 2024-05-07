package entity;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:36
 * @description:
 **/
public class Pet {
	private Integer id;
	private String nickname;
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User getUser() {
		return user;
	}

	public void setUse(User user) {
		this.user = user;
	}
	//
	//@Override
	//public String toString() {
	//	return "Pet{" +
	//			"id=" + id +
	//			", nickname='" + nickname + '\'' +
	//			", user=" + user +
	//			'}';
	//}
}
