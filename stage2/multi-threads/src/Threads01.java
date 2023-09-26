/**
 * @author qiaolezi
 * @version 1.0
 * 继承thread类创建线程
 */
public class Threads01 {
	public static void main(String[] args) throws InterruptedException{
//		创建一个Cat对象，可以当做线程使用
		Cat cat = new Cat();

		cat.start();//启动线程


//		说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，而是继续执行
//		主线程和子线程 交替执行
//		cat.run();//该方法只是一个普通方法，没有真正启动线程，将run()方法执行完毕，才向下执行

		System.out.println("主线程继续执行" + Thread.currentThread().getName());
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程i=" + i);
			Thread.sleep(1000);
		}
	}
}

//当一个类继承 Thread 类，该类可以当做线程使用
//一般会重写 run() 方法，写自己的业务代码
//Thread 类 实现了 Runnable 接口的 run() 方法
class Cat extends Thread {
	int times = 0;
	@Override
	public void run() {//重写 run() 方法，实现自己的业务逻辑
//		每间隔1秒，输出 ”汪汪汪“
		while (true) {
			System.out.println("汪汪汪" + (++times) + "     线程名称=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if(times == 80) {
				break;//退出while，线程直接退出
			}
		}
	}
}