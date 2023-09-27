/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork02 {
	public static void main(String[] args) {
		P p = new P();
		new Thread(p).start();
		new Thread(p).start();
	}
}

class P extends Thread {
	private static int money = 10;
	private boolean loop = true;
	@Override
	public void run() {
		while(loop) {
			sell();
		}
	}

//	TODO 先判断余额，再取钱！！！  顺序！
//	TODO 在money较小的情况下（10），把休眠放进同步代码块中，如果休眠时间过短（5毫秒/不休眠），会导致另一个线程抢不到锁
//	TODO 在同步代码块外面休眠，会保证两个线程轮流抢到锁
	private /*synchronized*/ void sell() {
		synchronized(this) {
			if (money <= 0) {
				System.out.println("余额不足！");
				loop = false;
				return;
			}
			System.out.println("线程" + Thread.currentThread().getName() + "取了1元，余额=" + (--money));
//			try {
//				Thread.sleep(5);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
//		try {
//			Thread.sleep(1);//TODO 保证此锁被多线程轮流抢到
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("1");//也能保证此锁被多线程轮流抢到
	}
}