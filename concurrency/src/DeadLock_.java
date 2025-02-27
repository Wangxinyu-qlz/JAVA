/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2025-02-24 15:12
 * @description:
 **/
public class DeadLock_ {
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	public void getLock1() {
		synchronized (lock1) {
			System.out.println("获取lock1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("等待lock2");
			getLock2();
		}
	}

	public void getLock2() {
		synchronized (lock2) {
			System.out.println("获取lock2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("等待lock1");
			getLock1();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLock_ deadLock_ = new DeadLock_();
		Thread thread1 = new Thread(() -> {
			deadLock_.getLock1();
		});
		thread1.setName("thread1");
		thread1.start();
		Thread thread2 = new Thread(() -> {
			deadLock_.getLock2();
		});
		thread2.setName("thread2");
		thread2.start();

		thread1.join();
		thread2.join();
	}
}
