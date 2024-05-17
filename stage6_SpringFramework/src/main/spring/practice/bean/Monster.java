package main.spring.practice.bean;

import main.spring.bean.Department;

import java.util.*;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-15 20:52
 * @description:
 **/
public class Monster {
	private Integer id;
	private String name;
	private String address;
	private Department department;
	private List<Cat> catList;
	private Set<Cat> catSet;
	private Map<String, Cat> catMap;
	private String[] catName;
	private Properties properties;

	public void init() {
		this.name = "杰瑞";
		System.out.println("这是" + this.name + "init捣乱了吧");
	}

	public void destroy() {
		System.out.println("杰瑞走了");
	}

	public Monster() {
		System.out.println("Monster::Constructor NULL");
	}

	public Monster(Integer id, String name, String address, Department department,
	               List<Cat> catList, Set<Cat> catSet, Map<String, Cat> catMap,
	               String[] catName, Properties properties) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.catList = catList;
		this.catSet = catSet;
		this.catMap = catMap;
		this.catName = catName;
		this.properties = properties;
		System.out.println("Monster::Constructor");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Cat> getCatList() {
		return catList;
	}

	public void setCatList(List<Cat> catList) {
		this.catList = catList;
	}

	public Set<Cat> getCatSet() {
		return catSet;
	}

	public void setCatSet(Set<Cat> catSet) {
		this.catSet = catSet;
	}

	public Map<String, Cat> getCatMap() {
		return catMap;
	}

	public void setCatMap(Map<String, Cat> catMap) {
		this.catMap = catMap;
	}

	public String[] getCatName() {
		return catName;
	}

	public void setCatName(String[] catName) {
		this.catName = catName;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Monster{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", department=" + department +
				", catList=" + catList +
				", catSet=" + catSet +
				", catMap=" + catMap +
				", catName=" + Arrays.toString(catName) +
				", properties=" + properties +
				'}';
	}
}
