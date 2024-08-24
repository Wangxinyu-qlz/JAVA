import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-19 21:19
 * @description: 并发问题
 * hashmap并发问题：
 * hashMap被多个线程调用
 * 可以在方法上加锁，或者在调用处加锁
 * synchronized (map) {
 * for (int i = 0; i < 100; i++) {
 * map.put("a", map.get("a") + 1);
 * }
 * }
 * TODO ConcurrentHashMap 也是不安全的
 *  这个实验的题眼根本不在map上，map 已经初始化好，
 *  多线程操作过程中没有产生扩缩容，
 *  这个map就算不加锁也是安全的。
 *  问题在value上
 *  刚刚的说法不够严谨，不能说不发生扩缩容就是安全的，应该说：
 *  多线程下对 map 的 key 没有做任何删改，这个 map 就是安全的，
 *  至于怎么改 key 对应的 value。那是 value
 *  自身需要考虑的并发安全，不在上层容器安全控制管辖内。
 **/
public class ThreadTest extends Thread {
	private Map<String, Integer> map;

	public ThreadTest(Map map) {
		this.map = map;
	}

	public void run() {
		synchronized (map) {
			for (int i = 0; i < 100; i++) {
				map.put("a", map.get("a") + 1);
			}
		}
	}
}

class Test2 {
	public void test() throws InterruptedException {
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("a", 0);
		ThreadTest t1 = new ThreadTest(map);
		ThreadTest t2 = new ThreadTest(map);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.get("a"));//随机数
	}

	public static void main(String[] args) throws InterruptedException {
		Test2 t = new Test2();
		for (int i = 0; i < 10000; i++) {
			t.test();
		}
	}
}