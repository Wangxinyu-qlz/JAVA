import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-14 21:26
 * @description: 可重入锁
 **/
public class ReentrantLock_ {
	private static int inc = 0;
	//TODO 使用可重入锁
	ReentrantLock lock = new ReentrantLock();
	public void increase() {
		lock.lock();
		try {
			inc++;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ReentrantLock_ reentrantLock = new ReentrantLock_();
		for (int i = 0; i < 5; i++) {
			executorService.execute(()->{
				for (int j = 0; j < 100; j++) {
					reentrantLock.increase();
				}
			});
		}
		executorService.shutdown();
		while(!executorService.isTerminated()){}
		System.out.println(inc);
	}
}
