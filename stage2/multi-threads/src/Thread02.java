/**
 * @author qiaolezi
 * @version 1.0
 * TODO 通过实现接口 Runnable 开发线程  推荐使用此方法，可以使多个线程共享一个资源
 * TODO 底层使用设计模式-代理模式
 */
public class Thread02 {
	public static void main(String[] args) {
//		Dog dog = new Dog();
////		dog.start();//Error没有该方法
//		Thread thread = new Thread(dog);
//		thread.start();

		Tiger tiger = new Tiger();
		ThreadProxy threadProxy = new ThreadProxy(tiger);
		threadProxy.start();
	}
}

class Animal {}

class Tiger extends Animal implements Runnable{

	@Override
	public void run() {
		System.out.println("嗷嗷嗷");
	}
}

//模拟了简化的Thread类
class ThreadProxy implements Runnable {//当做Thread类
	private Runnable target = null;
	@Override
	public void run() {
		if(target != null) {
			target.run();
		}
	}

	public ThreadProxy(Runnable target) {
		this.target = target;
	}

	public void start() {
		start0();//真正实现多线程的方法
	}

	public void start0() {
		run();
	}
}

class Dog implements Runnable {
	int count = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println("汪汪汪！" + (++count));

//		    休眠1秒
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if(count == 10) {
				break;
			}
		}
	}
}