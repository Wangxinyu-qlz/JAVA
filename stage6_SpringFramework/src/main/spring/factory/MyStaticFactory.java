package main.spring.factory;

import main.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-16 09:43
 * @description: 静态工厂类，返回Monster对象
 **/
public class MyStaticFactory {
	private static Map<String, Monster> monsterMap;

	//使用 static 代码块，进行初始化
	//类加载时执行，只会执行一次
	static {
		monsterMap = new HashMap<>();
		monsterMap.put("monster111", new Monster(100, "牛魔", "撼天动地"));
		monsterMap.put("monster02", new Monster(2, "猴子", "火眼金睛"));
	}

	//提供一个静态方法，返回Monster对象
	public static Monster getMonster(String key) {
		return monsterMap.get(key);
	}
}
