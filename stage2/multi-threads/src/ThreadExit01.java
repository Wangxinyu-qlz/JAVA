/**
 * @author qiaolezi
 * @version 1.0
 */
public class ThreadExit01 {
	public static void main(String[] args) throws InterruptedException {
		T3 t3 = new T3();
		t3.start();

//		如果希望主线程控制T3线程的终止，需要可以修改loop
//		让T3退出run()方法，终止T3线程 -> 通知方式
//	    让主线程休眠10秒
		System.out.println("主线程休眠10s");
		Thread.sleep(10 * 1000);
		t3.setLoop(false);
	}
}

class T3 extends Thread {
	private int count = 0;
	private boolean loop = true;
	@Override
	public void run() {

		while(loop) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("T3运行中..." + (++count));

		}
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
}