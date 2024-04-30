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
	//添加monster
	void addMonster(Monster monster);
	//删除
	void deleteMonster(Integer monsterId);
	//修改
	void updateMonster(Monster monster);
	//查询-根据id
	Monster getMonsterById(Integer monsterId);
	//查询所有的Monster
	List<Monster> getAllMonsters();
}
