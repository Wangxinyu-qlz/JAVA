import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 * List的古老实现，是线程安全的
 */
public class Vector_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		线程安全的
//		如果是无参构造器，默认10，满后，扩容为2倍
//		如果是有参构造器，指定大小，满后，扩容为2倍
		Vector vector = new Vector();
//		Vector vector = new Vector(3);
		for (int i = 0; i < 10; i++) {
			vector.add(i);
		}
		vector.add(100);

	}
}
