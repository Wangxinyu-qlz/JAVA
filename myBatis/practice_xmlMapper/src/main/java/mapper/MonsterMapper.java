package mapper;

import entity.Monster;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-27 16:50
 * @description:
 **/
public interface MonsterMapper {
	void insert(Monster monster);
	//多条件查询
	List<Monster> findMonsterByNameOrId(Monster monster);
	//模糊查询
	List<Monster> findMonsterByName(String name);
	//多条件查询 id>? && salary>?
	List<Monster> findMonsterByIdAndSalary(Map<String, Object> map);
}
