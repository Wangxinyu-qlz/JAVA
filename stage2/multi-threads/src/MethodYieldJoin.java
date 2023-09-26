/**
 * @author qiaolezi
 * @version 1.0
 */
public class MethodYieldJoin {
	public static void main(String[] args) throws InterruptedException {
		T5 t5 = new T5();
		t5.start();

		for (int i = 0; i <= 20; i++) {
			Thread.sleep(1000);
			System.out.println("主线程~（小弟）" + i);
			if(i ==5) {
				System.out.println("主线程（小弟）让子线程（老大） 先执行");
//				t5.join();//让子线程插队 先执行
				Thread.yield();//礼让，不一定成功，让别人（子线程）先执行
				System.out.println("子线程执行完了~");
			}
		}
	}
}

class T5 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程(老大)~" + i);
		}
	}
}