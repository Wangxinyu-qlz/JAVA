/**
 * @author qiaolezi
 * @version 1.0
 */
public class MethodInterrupt {
	public static void main(String[] args) throws InterruptedException {
		T4 t4 = new T4();
		t4.setName("w");
		t4.setPriority(Thread.MIN_PRIORITY);
		t4.start();

//		在主线程中打印5个 hi，就中断子线程的休眠
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println("hi~");
		}

		System.out.println(t4.getName() + "线程优先级=" + t4.getPriority());
		t4.interrupt();

	}
}

class T4 extends Thread {
	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " 活动中~" + i);
			}
			try {
				System.out.println(Thread.currentThread().getName() + " 休眠中~");
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "被 interrupt了");
			}
		}
	}
}
