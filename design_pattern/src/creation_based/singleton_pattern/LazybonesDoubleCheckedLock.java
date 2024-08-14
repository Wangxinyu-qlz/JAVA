package creation_based.singleton_pattern;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:50
 * @description:
 **/
//线程安全，双重校验锁
public class LazybonesDoubleCheckedLock {
	//uniqueInstance 采用 volatile 关键字修饰也是很有必要的。
	// uniqueInstance = new Singleton();
	// 这段代码其实是分为三步执行。
	// 1.分配内存空间
	// 2.初始化对象
	// 3.将 uniqueInstance 指向分配的内存地址
	//在多线程环境下，由于指令重排序的存在，步骤 2 和 3 可能会被重排序，
	// 即先将内存地址赋值给 uniqueInstance，然后再初始化对象。
	// 这就导致了一个问题：假设线程 A 正在执行这个过程，
	// 线程 B 发现 uniqueInstance 不为 null，
	// 于是返回了这个尚未初始化完全的对象（没有就创建，有就返回），从而产生了错误的行为。
	//所以加上了volatile的对象，也保证了在第二次检查时不会被已经在创建过程中的对象又被检测为空的风险。
	// TODO 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。

	//保证可见性：volatile 还确保了 uniqueInstance 的最新值对所有线程是可见的。
	// 当一个线程修改了 uniqueInstance，其他线程立即能够看到修改后的值，而不会使用缓存中的过期数据。

	private volatile static LazybonesDoubleCheckedLock uniqueZInstance;

	private LazybonesDoubleCheckedLock() {}

	//双重校验锁先判断 uniqueInstance 是否已经被实例化，
	// 如果没有被实例化，那么才对实例化语句进行加锁。
	public static LazybonesDoubleCheckedLock getUniqueZInstance() {
		/*
		当第一个线程走到第一次检查时发现对象为空，然后进入锁，
		第二次检查时也为空，那么就去创建对象，但是这个时候又来了一个线程来到了第一次检查，
		发现为空，但是这个时候因为锁被占用，所以就只能阻塞等待，
		然后第一个线程创建对象成功了，由于对象是被 volatile 修饰的能够立即反馈到其他线程上，
		所以在第一个线程释放锁之后，第二个线程进入了锁，然后进行第二次检查时，
		发现对象已经被创建了，那么就不在创建对象了。从而保证的单例。

		考虑下面的实现，也就是只使用了一个 if 语句。
		在 uniqueInstance == null 的情况下，如果两个线程同时执行 if 语句，
		那么两个线程就会同时进入 if 语句块内。虽然在 if 语句块内有加锁操作，
		但是两个线程都会执行 uniqueInstance = new Singleton();
		只是先后的问题，那么就会进行两次实例化，从而产生了两个实例。
		因此必须使用双重校验锁，也就是需要使用两个 if 语句。
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
		        uniqueInstance = new Singleton();
		    }
		}
		 */
		if (uniqueZInstance == null) {
			/*
			类锁与对象锁:
				对象锁：通常是在 synchronized 关键字后面跟着一个实例对象，
					如 synchronized (this)，它是针对特定对象实例进行加锁，
					不同实例对象的锁是互不干扰的。
				类锁：synchronized (ClassName.class)
					这种方式会对整个类对象（即 Class 对象）加锁，
					Class 对象是 JVM 在加载类时自动创建的唯一对象，它代表了该类的所有实例。
					因此，使用类锁时，所有对这个类的同步操作都会被该锁阻塞，
					意味着无论有多少个实例对象，使用类锁时都只能有一个线程能够进入同步代码块。
			锁范围：
				当一个线程获取了 LazybonesDoubleCheckedLock.class 的锁后，
				其他任何试图进入同一类的 synchronized (LazybonesDoubleCheckedLock.class)
				代码块的线程都会被阻塞。
				这也意味着，使用类锁时，锁的范围是整个类，而不仅仅是某个实例，
				因此这种锁通常用于需要确保对类级别的资源（如静态变量）进行同步访问的情况。
			应用场景：
				类锁通常用于控制对静态变量的访问，因为静态变量属于类而不是某个实例。
				适用于单例模式中，确保在并发环境下只有一个实例被创建。
			 */
			//类锁：锁住当前类  （锁住静态方法  锁住静态变量）
			synchronized (LazybonesDoubleCheckedLock.class) {
				if(uniqueZInstance == null) {
					//17 new #8 <creation_based/singleton_pattern/LazybonesDoubleCheckedLock>
					//20 dup
					//21 invokespecial #13 <creation_based/singleton_pattern/LazybonesDoubleCheckedLock.<init> : ()V>
					//24 putstatic #7 <creation_based/singleton_pattern/LazybonesDoubleCheckedLock.uniqueZInstance : Lcreation_based/singleton_pattern/LazybonesDoubleCheckedLock;>
					//new 指令创建一个LazybonesDoubleCheckedLock类的新实例。
					//dup 复制这个新创建的实例引用，以便将其同时用于构造函数调用和putstatic指令。
					//invokespecial 调用构造函数初始化新对象。
					//putstatic 将新创建的对象存储在uniqueZInstance静态字段中。
					uniqueZInstance = new LazybonesDoubleCheckedLock();
				}
			}
		}
		return uniqueZInstance;
	}

	public static void main(String[] args) {
		LazybonesDoubleCheckedLock instance = LazybonesDoubleCheckedLock.getUniqueZInstance();
	}
}
