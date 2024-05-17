package main.spring.practice.factory;

import main.spring.practice.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 21:32
 * @description:
 **/
public class StaticFactory {
	private static Map<String, Monster> monsterMap;
	static {
		//TODO Map是接口
		monsterMap = new HashMap<String, Monster>();
		Monster monster1 = new Monster();
		monster1.setId(111111);
		monsterMap.put("monster1", monster1);
		Monster monster2 = new Monster();
		monster2.setId(222222);
		monsterMap.put("monster2", monster2);
	}

	public static Monster getMonster(String key) {
		return monsterMap.get(key);
	}
}
