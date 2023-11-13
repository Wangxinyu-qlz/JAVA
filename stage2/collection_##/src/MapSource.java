import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class MapSource {
	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("no1", "tomi");//K-V
		map.put("no2", "joy");//k-v
		map.put(new K(), new V());
//		Map 存放数据的方式：一对K-V放在一个 HashMap$Node 中
//		又因为 Node 实现了 Entry 接口，
//		1.k-v 最后是 HashMap$Node node = newNode(hash, key, value, null)
//		2.k-v 为了方便程序员遍历，还会创建 EntrySet 集合，该集合存放的元素类型是 Entry
//		所以一个 Entry 对象就有 k,v EntrySet<K,V> 即： transient Set<Map.Entry<K,V>> entrySet;
//      3.在 EntrySet 中，定义的类型是 Map.Entry，但实际上存放的是 HashMap$Node
//      这是因为 HashMap$Node implements Map.Entry
//		4.当把 HashMap$Node 对象存放到 entrySet 方便遍历，
//		因为Map.Entry提供了getKey()和getValue()方法
		Set set = map.entrySet();
		System.out.println(set.getClass());//class java.util.HashMap$EntrySet
		for(Object obj: set) {
			System.out.println(obj.getClass());//class java.util.HashMap$Node
//			为了从HashMap$Node 中取出 k-v
//			1.先做一个向下转型
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry.getKey() + "-" + entry.getValue());//no2-joy  no1-tomi
		}

		Set set1 = map.keySet();
		System.out.println(set1.getClass());//class java.util.HashMap$KeySet
		Collection values = map.values();
		System.out.println(values.getClass());//class java.util.HashMap$Values
	}
}

class K {}

class V {}