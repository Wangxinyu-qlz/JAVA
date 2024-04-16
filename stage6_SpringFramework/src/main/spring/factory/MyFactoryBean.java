package main.spring.factory;

import main.spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-16 10:29
 * @description: FactoryBean
 **/
public class MyFactoryBean implements FactoryBean<Monster> {
	//在配置时，指定要获取的对象的key
	private String key;
	private Map<String, Monster> monsterMap;

	//初始化
	{
		monsterMap = new HashMap<>();
		monsterMap.put("monster01", new Monster(100, "牛魔", "撼天动地"));
		monsterMap.put("monster02", new Monster(200, "孙悟空", "火眼金睛"));
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public Monster getObject() throws Exception {
		return monsterMap.get(key);
	}

	@Override
	public Class<?> getObjectType() {
		return Monster.class;
	}

	@Override
	public boolean isSingleton() {//这里指定是否返回是单例：在整个系统中，某个类只能存在一个对象实例并只提供一个取得其对象实例的方法
		//return FactoryBean.super.isSingleton();//这里默认是true
		return true;
	}
}
