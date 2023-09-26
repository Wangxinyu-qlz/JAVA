/**
 * @author qiaolezi
 * @version 1.0
 */
public class MethodMaemon {
	public static void main(String[] args) throws InterruptedException {
		MyDaemonThread myDaemonThread = new MyDaemonThread();
//	    希望主线程结束后，子线程自动结束
//		将子线程设置为守护线程
		myDaemonThread.setDaemon(true);
		myDaemonThread.start();
		for (int i = 0; i <= 5; i++) {
			System.out.println("工作~");
			Thread.sleep(1000);
		}
	}
}

class MyDaemonThread extends Thread {
	@Override
	public void run() {
		for(; ;) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("聊天~");
		}
	}
}