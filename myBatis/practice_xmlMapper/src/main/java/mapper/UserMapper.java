package mapper;

import entity.User;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-28 09:42
 * @description:
 **/
public interface UserMapper {
	void addUser(User user);
	List<User> findAllUsers();
}
