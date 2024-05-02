package mapper;

import entity.Monster;

import java.util.List;

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
}
