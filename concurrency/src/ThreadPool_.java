import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-14 18:11
 * @description:
 **/
public class ThreadPool_ {
	//public volatile static int inc = 0;
	public static LongAccumulator inc = new LongAccumulator((left, right) -> left + right, 0);
	//TODO volatile不能保证原子性，仍然需要synchronized 或者
	//public synchronized void increase() {
	//	//inc++;//取值，+1，写回
	//}

	public  void increase() {
		inc.accumulate(1);
	}

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(5);
		ThreadPool_ threadPool = new ThreadPool_();
		for (int i = 0; i < 5; i++) {
			executors.execute(()->{
				for (int j = 0; j < 1000; j++) {
						threadPool.increase();
				}
			});
		}
		//关闭线程池
		//但是，执行完这个方法后，线程池不一定会立即停止；
		//  ● 这是因为，shutdown只是初始化整个关闭过程；
		//  ● 比如，线程池在执行到一半时，线程中有正在执行的任务，队列中也可能有等待被执行的任务；所以，不是我们调用shutdown方法后，整个线程池就能停的；
		//  ● 在我们调用了shutdown方法后，线程池就知道了【我们想要停止线程池的意图】；这个时候，为了安全起见，线程池会把正在执行的任务及队列中等待执行的任务都执行完毕后，再去关闭；
		//  ● 自然，在我们调用了shutdown方法后，如果还有新的任务过来，线程池就会拒绝；
		executors.shutdown();
		//shutdownNow():立即停止线程池，执行中的任务会被中断3，队列中的任务会返回
		//终止线程的方法是通过调用Thread.interrupt()方法来实现的，
		// 这种方法的作用有限，如果线程中没有sleep 、wait、Condition、定时锁等应用,
		// interrupt()方法是无法中断当前的线程的。所以，ShutdownNow()并不代表线程池就一定立即就能退出，
		// 它可能必须要等待所有正在执行的任务都执行完成了才能退出。
		//等待上面的线程执行完 判断线程池是否已经彻底停止了
		while(!executors.isTerminated()){}
		System.out.println(inc);

	}
}
