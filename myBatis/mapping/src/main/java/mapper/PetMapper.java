package mapper;

import entity.Pet;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 16:43
 * @description:
 **/
public interface PetMapper {
	//根据id 查询pet信息，包括User信息
	Pet getPetById(Integer id);

	//一个 user 可能有多个 pets 所以使用 List
	List<Pet> getPetByUserId(Integer UserId);
}
