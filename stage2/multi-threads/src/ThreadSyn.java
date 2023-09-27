/**
 * @author qiaolezi
 * @version 1.0
 */
public class ThreadSyn {
	public static void main(String[] args) {
		SellTicket03 sellTicket03 = new SellTicket03();
		new Thread(sellTicket03).start();
		new Thread(sellTicket03).start();
		new Thread(sellTicket03).start();
	}
}

//实现接口方式，使用synchronized实现线程同步
class SellTicket03 extends Thread {
	private static int ticketNum = 50;
	private boolean loop = true;
	Object object = new Object();
	Car c = new Car();

//	TODO 同步方法（静态的）的锁加在 当前类本身 SellTicket03.class
	public synchronized static void m1() {}
	public static void m2() {
		synchronized(SellTicket03.class) {
			System.out.println("m2");
		}
	}
//	TODO 1.public synchronized void sell() {} 是一个同步方法，锁在 this 对象
//	TODO 2.也可以在代码块上写 synchronized，同步代码块，互斥锁加在 this 对象
	public /*synchronized*/ void sell() {//TODO 同步方法，在同一时刻，只能有一个线程执行 run 方法
		//TODO 这里换成object也行，因为三个线程中是同一个对象，其操作的object肯定也是同一个，c（Car）同理
		synchronized (/*this*//*object*/c) {
			if(ticketNum <= 0) {
				System.out.println("票买完了~");
				loop = false;
				return;
			}
			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票。" + "剩余票数=" + (--ticketNum));
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while(loop) {
			sell();
		}
	}
}

class Car {}