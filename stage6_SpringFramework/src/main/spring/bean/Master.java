package main.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-07 11:33
 * @description: Master类
 **/
public class Master {
	private String name;//主人名称
	private List<Monster> monsterList;
	private Map<String, Monster> monsterMap;
	private Set<Monster> monsterSet;

	private String[] monsterName;
	//Properties是Hashtable的子类，K:String-V:String
	private Properties pros;
}
