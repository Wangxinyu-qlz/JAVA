/**
 * @author qiaolezi
 * @version 1.0
 */
public class DeadLock {
	public static void main(String[] args) {
		DeadLockDemo A = new DeadLockDemo(true);
		DeadLockDemo B = new DeadLockDemo(false);
		A.start();
		B.start();
	}
}

class DeadLockDemo extends Thread {
	static Object o1 = new Object();
	static Object o2 = new Object();
	boolean flag;

	public DeadLockDemo(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
//		业务逻辑分析：
//		1.flag=true，线程A持有o1对象锁，然后尝试获取o2对象锁
//		2.如果线程A得不到o2对象锁，就会Blocked
//		3.flag=false，线程B持有o2对象锁，然后尝试获取o1对象锁
//		4.如果线程B得不到o1对象锁，就会Blocked
		if(flag) {
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "进入1");
				synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "进入2");
				}
			}
		} else {
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "进入3");
				synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "进入4");
				}
			}
		}
	}
}
