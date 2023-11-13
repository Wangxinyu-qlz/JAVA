import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork02 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add("A");
		}

		list.add(1, "lsp");
		System.out.println("第5个元素为：" + list.get(4));
		list.remove(5);
		list.set(6, "V");

		System.out.println("=======遍历=======");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}
	}
}
