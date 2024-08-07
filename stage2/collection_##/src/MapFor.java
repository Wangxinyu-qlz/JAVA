import java.util.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class MapFor {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Map map = new HashMap();

		map.put("a", new Book2("", 100));//OK
		map.put("a", "b");//替换
		map.put("c", "d");//OK
		map.put("z", "d");//OK
		map.put("h", null);//OK
		map.put(null, "r");//OK
		map.put("j", "w");//OK

//		第一组：先取出所有的Key，在通过 Key 取出对应的 Value
		Set keySet = map.keySet();
//		（1）增强for
		System.out.println("第1种：");
		for(Object key : keySet) {
			System.out.println(key + "-" + map.get(key));
		}
//		迭代器
		System.out.println("第2种：");
		Iterator iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Object key =  iterator.next();
			System.out.println(key + "-" + map.get(key));
		}

//		第二组：把所有的Values取出
		Collection values = map.values();
//		这里可以使用所有Collection使用的遍历方法
//		（1）增强for
		System.out.println("第3种：");
		for(Object value : values) {
			System.out.println(value);
		}
//		（2）迭代器
		System.out.println("第4种：");
		Iterator iterator1 = values.iterator();
		while (iterator1.hasNext()) {
			Object value =  iterator1.next();
			System.out.println(value);
		}

//		TODO 第三组：通过 EntrySet 获取 Key-Value
		Set entrySet = map.entrySet();//EntrySet<Map.Entry<K,V>>
//		（1）增强for
		for (Object entry : entrySet) {
//			将entry 转成 Map.Entry
			Map.Entry m = (Map.Entry) entry;
			System.out.println(m.getKey() + "-" + m.getValue());
		}
//		（2）迭代器
		Iterator iterator2 = entrySet.iterator();;
		while (iterator2.hasNext()) {
			Object entry =  iterator2.next();
//			System.out.println(entry.getClass());//class java.util.HashMap$collection.Node
//			HashMap$collection.Node -实现->Map.Entry(getKey,getValue)
//			向下转型 Map.Entry
			Map.Entry m = (Map.Entry) entry;
			System.out.println(m.getKey() + "-" + m.getValue());

		}
	}
}


@SuppressWarnings({"all"})
class Book2 {
	private String name;
	private int num;

	public Book2(String name, int num) {
		this.name = name;
		this.num = num;
	}
}