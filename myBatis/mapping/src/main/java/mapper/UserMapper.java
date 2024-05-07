package mapper;

import entity.User;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:43
 * @description:
 **/
public interface UserMapper {
	User getUserById(Integer id);
}
