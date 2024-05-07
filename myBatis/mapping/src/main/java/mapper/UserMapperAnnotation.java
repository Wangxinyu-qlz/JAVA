package mapper;

import entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 17:34
 * @description:
 **/
public interface UserMapperAnnotation {
	@Select("select * from `users` where `id` = #{id}")
	//TODO 注意这里的{}
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "pets", column = "id",
					many = @Many(select = "mapper.PetMapper.getPetByUserId"))
	})
	User getUserById(Integer id);
}