package mapper;

import entity.Monster;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 09:15
 * @description:
 **/
public interface MonsterMapper {
	void addMonster(Monster monster);

	void delMonster(Integer id);

	void updateMonster(Monster monster);

	public Monster selectMonster(Integer id);

	public List<Monster> getAllMonsters();
}
