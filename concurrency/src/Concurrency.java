import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 20:30
 * @description:
 **/
public class Concurrency {
	public static int THREAD_NUM = 10;
	public static int COUNT_NUM = 10000000;//千万
	//线程池
	public static CountDownLatch countDownLatch =
			new CountDownLatch(THREAD_NUM);

	//TODO volatile只能保证可见性和顺序性，但不能保证原子性，
	//  对于自增（获取值、自增、赋值）等复合操作，
	//  无法保证多线程下的安全性
	//public static Integer count = 0;
	//public static int count = 0;//4.8s

	//public static AtomicInteger count = new AtomicInteger();//1.7s

	//public static LongAdder count = new LongAdder();//0.13s

	public static LongAccumulator count = new LongAccumulator((left, right) -> left + right, 0);//0.11s
	//
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(() -> {
				for (int j = 0; j <COUNT_NUM ; j++) {
					//方式1
					//代码运行会将锁升级到重量级锁，比较耗时
					//synchronized (Concurrency.class) {
					//	count += 2;
					//}
					//方式2
					//AtomicInteger 类，在内存中使用CAS自旋累加，
					// 但是加的结果都指向内存中的一个变量，
					// 冲突会比较严重，耗时较多
					//count.addAndGet(2);
					// LongAdder 和 LongAccumulator 底层使用了
					// base（基本值）+ Cell[] cells（单元表）来保持数据，
					// 当需要进行累加一个值 n 时，根据线程的一个特有值计算
					// 得到对应的cells[i]，执行 cells[i] = cells[i] + n，
					// 如果冲突可以对 cells 扩容，或者把值 n 累加到 base 上，
					// 这样就有多个变量可以进行累加，最后求和是只要把 base 和
					// cells 数组中的值都加起来即可。
					// （ConcurrentHashMap 中，添加元素后对集合大小累加时，
					// 也是这样方案）
					//方式3
					//count.add(2);
					//方式4
					count.accumulate(2);
				}
				countDownLatch.countDown();
			}).start();
		}
		/*
		作用是让当前线程等待，直到CountDownLatch的计数器变为零。
		当计数器变为零时，所有等待在await()上的线程都会被唤醒并继续执行。
		确保主线程在所有子线程完成各自的任务（即计数器减到零）之前不会继续执行，
		从而保证在输出 System.out.println(count); 时，所有的累加操作已经完成。
		是一种线程同步机制，用来等待其他线程完成各自的任务。
		 */
		countDownLatch.await();
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("耗时：" + (end - start));
	}
}
