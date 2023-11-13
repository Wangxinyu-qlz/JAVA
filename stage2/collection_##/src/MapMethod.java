import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class MapMethod {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		Map map = new HashMap();

		map.put("a", new Book_("", 100));//OK
		map.put("a", "b");//替换
		map.put("c", "d");//OK
		map.put("z", "d");//OK
		map.put("h", null);//OK
		map.put(null, "r");//OK
		map.put("j", "w");//OK

		System.out.println("map=" + map);

		map.remove(null);
		System.out.println(map);
		System.out.println(map.get("j"));//w
		System.out.println(map.size());//5
		System.out.println(map.isEmpty());//false
//		map.clear();
//		System.out.println(map);//{}
		System.out.println(map.containsKey("set"));//false
		System.out.println(map.containsKey("j"));//true
	}
}


class Book_ {
	private String name;
	private int num;

	public Book_(String name, int num) {
		this.name = name;
		this.num = num;
	}
}