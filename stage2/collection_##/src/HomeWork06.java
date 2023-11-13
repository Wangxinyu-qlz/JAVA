import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork06 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Map map = new HashMap();

		map.put("jack", 650);
		map.put("tom", 1200);
		map.put("smith", 2900);
		map.put("jack", 2600);
		map.replace("jack", 650, 2600);

		Set keySet = map.keySet();
		for(Object key : keySet) {
//			更新 TODO map.get(key)是Object类型 需要向下转型 Integer
			map.put(key, (Integer) map.get(key) + 100);
		}

		for(Object key : keySet) {
			System.out.println(map.get(key));
		}

		for(Object key : keySet) {
			System.out.println(key);
		}

		Set entrySet = map.entrySet();
		for (Object obj : entrySet) {
			Map.Entry entry = (Map.Entry) obj;
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		Iterator iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Object next =  iterator.next();
			Map.Entry entry = (Map.Entry) next;
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
}