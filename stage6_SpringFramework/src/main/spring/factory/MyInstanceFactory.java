package main.spring.factory;

import main.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-16 10:00
 * @description:
 **/
public class MyInstanceFactory {
	private Map<String, Monster> monsterMap;

	//使用 普通 代码块，进行初始化
	//类实例化时，都会执行
	{
		monsterMap = new HashMap<>();
		monsterMap.put("monster03", new Monster(300, "牛魔~", "撼天动地"));
		monsterMap.put("monster04", new Monster(400, "孙悟空~", "火眼金睛"));
	}

	//提供一个方法，返回Monster对象
	public  Monster getMonster(String key) {
		return monsterMap.get(key);
	}
}
