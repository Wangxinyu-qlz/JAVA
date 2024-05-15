package main.spring.practice.factory;

import main.spring.practice.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 21:59
 * @description:
 **/
public class InstanceFactory {
	private Map<String, Monster> monsterMap;
	{
		monsterMap = new HashMap<String, Monster>();
		Monster monster1 = new Monster();
		monster1.setId(111);
		Monster monster2 = new Monster();
		monster2.setId(222);
		monsterMap.put("monster1", monster1);
		monsterMap.put("monster2", monster2);
	}

	public Monster getMonster(String key) {
		return monsterMap.get(key);
	}
}
