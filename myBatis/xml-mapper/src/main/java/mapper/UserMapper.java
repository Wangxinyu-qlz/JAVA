package mapper;

import entity.User;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-02 15:51
 * @description:
 **/
public interface UserMapper {
	void addUser(User user);

	List<User> getAllUser();
}
