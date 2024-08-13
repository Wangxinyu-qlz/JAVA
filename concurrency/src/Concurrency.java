import java.util.concurrent.CountDownLatch;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 20:30
 * @description:
 **/
public class Concurrency {
	public static int THREAD_NUM = 10;
	public static int COUNT_NUM = 1000;
	//线程池
	public static CountDownLatch countDownLatch =
			new CountDownLatch(THREAD_NUM);

	//public static Integer count = 0;
	//TODO 只能保证可见性和顺序性，但不能保证原子性，
	// 对于自增（获取值、自增、赋值）等复合操作，
	// 无法保证多线程下的安全性
	public static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(() -> {
				for (int j = 0; j <COUNT_NUM ; j++) {
					synchronized (Concurrency.class) {
						count += 2;
					}
				}
				countDownLatch.countDown();
			}).start();
		}
		countDownLatch.await();
		System.out.println(count);
	}
}
