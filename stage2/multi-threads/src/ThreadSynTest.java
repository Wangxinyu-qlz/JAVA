/**
 * @author qiaolezi
 * @version 1.0
 */
public class ThreadSynTest {
	public static void main(String[] args) {
//		锁生效，两个线程操作的是同一个对象
//		SellTicket04 sellTicket04 = new SellTicket04();
//		new Thread(sellTicket04).start();
//		new Thread(sellTicket04).start();

//		TODO 锁失效，操作的不是同一个对象
//		SellTicket04 sellTicket041 = new SellTicket04();
//		SellTicket04 sellTicket042 = new SellTicket04();
//		new Thread(sellTicket041).start();
//		new Thread(sellTicket042).start();

//		锁生效，两个线程操作的是同一个对象
		SellTicket05 sellTicket05 = new SellTicket05();
		new Thread(sellTicket05).start();
		new Thread(sellTicket05).start();

//		TODO 锁失效，操作的不是同一个对象
//		SellTicket05 sellTicket051 = new SellTicket05();
//		SellTicket05 sellTicket052 = new SellTicket05();
//		sellTicket051.start();
//		sellTicket052.start();
	}
}

class SellTicket04 implements Runnable {
	private static int ticketNum = 50;
	private boolean loop = true;

	public /*synchronized*/ void sell() {
		synchronized (this) {
			if(ticketNum <= 0) {
				System.out.println("票买完了~");
				loop = false;
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票。" + "剩余票数=" + (--ticketNum));
		}
	}

	@Override
	public void run() {
		while(loop) {
			sell();
		}
	}
}

class SellTicket05 extends Thread {
	private static int ticketNum = 50;
	private boolean loop = true;

	public /*synchronized*/ void sell() {
		synchronized (this) {
			if(ticketNum <= 0) {
				System.out.println("票买完了~");
				loop = false;
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票。" + "剩余票数=" + (--ticketNum));
		}
	}

	@Override
	public void run() {
		while(loop) {
			sell();
		}
	}
}