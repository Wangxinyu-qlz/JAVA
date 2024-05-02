package mapper;

import entity.Monster;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-04-30 16:22
 * @description: 用于声明操作monster表的方法
 * 通过注解  xml 文件实现
 **/
public interface MonsterMapper {

	//通过id或者name查询
	List<Monster> getMonsterByNameORId(Monster monster);

	//查询名字中包括'精'的妖怪
	List<Monster> getMonsterByName(String name);

	//查询 id > 10 && salary > 40.0
	//入参为 HashMap
	List<Monster> getMonsterByIdAndSalary_ParameterHashMap(Map<String, Object> map);

	//查询 id > 10 && salary > 40.0
	//入参为 HashMap
	//返回为 HashMap
	List<Map<String, Object>> getMonsterByIdAndSalary_ParameterHashMap_ReturnHashMap(Map<String, Object> map);
}
