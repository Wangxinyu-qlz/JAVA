package mapper;

import entity.Pet;
import org.apache.ibatis.annotations.*;

import javax.xml.bind.annotation.XmlSchema;
import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 17:35
 * @description:
 **/
public interface PetMapperAnnotation {

	@Select("select * from pets where id = #{id}")
	@Results(id="PetResultMap",
			value = {
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "nickname", column = "nickname"),
			@Result(property = "user", column = "user_id",
					one = @One(select = "mapper.UserMapperAnnotation.getUserById"))
	})
	Pet getPetById(Integer id);

	@Select("select * from `pets` where `user_id` = #{userId}")
	@ResultMap(value = "PetResultMap")//Results复用
	List<Pet> getPetsByUserId(Integer userId);
}
