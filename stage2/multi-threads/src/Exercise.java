/**
 * @author qiaolezi
 * @version 1.0
 */
public class Exercise {
	public static void main(String[] args) throws InterruptedException {
		Sub sub = new Sub();
		Thread thread = new Thread(sub);

		for (int i = 0; i < 10; i++) {
			System.out.println("hi~" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if(i == 5) {
				thread.start();
				thread.join();
			}
		}
		System.out.println("主线程结束");
	}
}

class Sub implements Runnable {
	private int count = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println("hello~" + (++count));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if(count == 10) {
				System.out.println("子线程结束");
				break;
			}
		}
	}
}
