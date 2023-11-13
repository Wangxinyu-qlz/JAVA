import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashMapSource {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("java", 10);
		map.put("Python", 10);
		map.put("java", 20);//替换value

		System.out.println(map);//{java=20, Python=10}

//		源码解读
//		1.执行构造器
//		执行加载因子，loadfactor=0.75
//		HashMap$Node[] table = null
//		2.执行put

	}
}
