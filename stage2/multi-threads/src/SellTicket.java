/**
 * @author qiaolezi
 * @version 1.0
 */
public class SellTicket {
	public static void main(String[] args) {
//		SellTicket01 sellTicket01 = new SellTicket01();
//		SellTicket01 sellTicket011 = new SellTicket01();
//		SellTicket01 sellTicket012 = new SellTicket01();
//
////		这里会出现票数超卖现象
//		sellTicket01.start();
//		sellTicket011.start();
//		sellTicket012.start();

//		仍然会超卖
//		根本原因是没有互斥锁
		SellTicket02 sellTicket02 = new SellTicket02();
		new Thread(sellTicket02).start();
		new Thread(sellTicket02).start();
		new Thread(sellTicket02).start();
	}
}

class SellTicket01 extends Thread {
	private static int ticketNum = 100;

	@Override
	public void run() {
		while(true) {

			if(ticketNum <= 0) {
				System.out.println("票买完了~");
				break;
			}

//			休眠50毫秒
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票。" + "剩余票数=" + (--ticketNum));
		}
	}
}

class SellTicket02 implements Runnable {
	private static int ticketNum = 100;
	@Override
	public void run() {
		while(true) {
			if(ticketNum <= 0) {
				System.out.println("票买完了~");
				break;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票。" + "剩余票数=" + (--ticketNum));
		}
	}
}