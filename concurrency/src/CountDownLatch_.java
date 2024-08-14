/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 20:30
 * @description:
 **/
public class CountDownLatch_ {
	public static int THREAD_NUM = 10;
	public static int COUNT_NUM_PER_THREAD = 10000;
	//线程池 倒计时锁
	public static java.util.concurrent.CountDownLatch countDownLatch =
			new java.util.concurrent.CountDownLatch(THREAD_NUM);

	//TODO volatile只能保证可见性和顺序性，但不能保证原子性，
	//  对于自增（获取值、自增、赋值）等复合操作，
	//  无法保证多线程下的安全性
	public static Integer count = 0;
	//public static int count = 0;//4.8s

	//public static AtomicInteger count = new AtomicInteger();//1.7s

	//public static LongAdder count = new LongAdder();//0.13s

	//public static LongAccumulator count = new LongAccumulator((left, right) -> left + right, 0);//0.11s
	//
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(() -> {
				for (int j = 0; j <COUNT_NUM_PER_THREAD ; j++) {
					//方式1 悲观锁
					//悲观锁总是假设最坏的情况，
					// 认为共享资源每次被访问的时候就会出现问题(比如共享数据被修改)，
					// 所以每次在获取资源操作的时候都会上锁，
					// 这样其他线程想拿到这个资源就会阻塞直到锁被上一个持有者释放。
					// 也就是说，共享资源每次只给一个线程使用，
					// 其它线程阻塞，用完后再把资源转让给其它线程。
					//TODO synchronized(count){}是线程不安全的
					// count 是一个静态的 Integer 对象，
					// 而 Integer 是不可变的对象（immutable），
					// [String 基本类型的包装类 BigInteger BigDecimal]
					// 这意味着每次对 count 的操作都会创建一个新的 Integer 对象。

					//使用 synchronized (count) 来加锁时，
					// 实际上是对当前 count 对象进行加锁，而不是对共享资源本身进行加锁。
					// 一旦 count 被修改，count 变量就指向了一个新的 Integer 对象，
					// 而其他线程仍然可能持有旧的 count 对象的锁，这导致了并发情况下的线程安全问题。
					synchronized (CountDownLatch_.class) {
						count += 2;
					}

					//方式2 乐观锁
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
					//count.accumulate(2);
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

	/*
	TODO accumulate() 方法是 synchronized 的，这意味着在同一时刻，只有一个线程可以执行这个方法中的代码。
	 但是，在 accumulate() 方法内部启动了多个线程，
	 每个线程运行的是一个新的 Runnable 实例，
	 这些线程是独立的，它们并不会受到 synchronized 方法的锁定限制。
	 */
	private static synchronized void accumulate() throws InterruptedException {
		for (int i=0; i<THREAD_NUM; i++) {
			new Thread(()->{
				for(int j = 0; j<COUNT_NUM_PER_THREAD; j++) {
					count += 2;
				}
				countDownLatch.countDown();
			}).start();
		}
		countDownLatch.await();
		System.out.println("count=" + count);
	}
}
