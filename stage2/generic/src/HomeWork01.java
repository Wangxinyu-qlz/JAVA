
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork01 {
	public static void main(String[] args) {

	}

	@Test
	public void testList() {
//		这里给T指定User类型
		DAO<User> dao = new DAO<>();
		dao.save("1", new User(1, 10, "king"));
		dao.save("9527", new User(9527, 10, "周星星"));
		dao.save("3", new User(3, 18, "大头"));

		List<User> list = dao.list();
		System.out.println("list=" + list);

		dao.update("3", new User(2, 23, "007"));
		list = dao.list();
		System.out.println(list);

		System.out.println("id=3" + dao.get("3"));
	}
}

class DAO<T> {
	private Map<String, T> map = new HashMap<>();
//	保存T类型的对象到Map成员变量中
	public void save(String id, T entity) {
		map.put(id, entity);
	}

//	从map中获取id对应的对象
	public T get(String id) {
		return map.get(id);
	}

//	替换map中key为id的内容，改为entity对象
	public void update(String id, T entity) {
		map.put(id, entity);
	}

//	返回map总存放的所有T对象
//	TODO 遍历 map<K, V> 将map的所有value(entity)，封装到ArrayList返回
	public List<T> list(){
		List<T> list = new ArrayList<>();
		Set<String> strings = map.keySet();
		for (String key : strings) {
			list.add(get(key));//TODO 调用了自己的get()方法
		}
		return list;
	}

//	删除指定id的对象
	public void delete(String id) {
		map.remove(id);
	}
}

class User {
	private int id;
	private int age;
	private String name;

	public User(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
