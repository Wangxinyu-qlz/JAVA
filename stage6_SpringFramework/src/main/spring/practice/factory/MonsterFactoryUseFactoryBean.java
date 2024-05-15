package main.spring.practice.factory;

import main.spring.practice.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 23:18
 * @description:
 **/
public class MonsterFactoryUseFactoryBean implements FactoryBean<Monster> {
	private String key;
	private Map<String, Monster> monsterMap;
	{
		monsterMap = new HashMap<String, Monster>();
		Monster monster = new Monster();
		Monster monster1 = new Monster();
		monster.setAddress("澳洲");
		monster1.setAddress("北美");
		monsterMap.put("monster", monster);
		monsterMap.put("monster1", monster1);
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Monster getObject() throws Exception {
		return monsterMap.get(key);
	}

	@Override
	public Class<?> getObjectType() {
		return Monster.class;
	}
}
