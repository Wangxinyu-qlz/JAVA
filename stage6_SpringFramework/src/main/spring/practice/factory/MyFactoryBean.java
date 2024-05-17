package main.spring.practice.factory;

import main.spring.bean.Department;
import main.spring.practice.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-16 18:23
 * @description:
 **/
public class MyFactoryBean implements FactoryBean<Monster> {
	private Map<String, Monster> monsters;
	private String key;
	{
		monsters = new HashMap<String, Monster>();
		Monster monster = new Monster();
		Monster monster2 = new Monster();
		monster.setDepartment(new Department("小强"));
		monster2.setDepartment(new Department("大壮"));
		monsters.put("monster1", monster);
		monsters.put("monster2", monster);
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
		return monsters.get(key);
	}

	@Override
	public Class<?> getObjectType() {
		return Monster.class;
	}
}
