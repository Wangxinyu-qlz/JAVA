package creation_based.singleton_pattern;

import java.io.Serializable;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:52
 * @description:
 * 使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 * 私有构造函数保证了不能通过构造函数来创建对象实例，
 * 只能通过公有静态函数返回唯一的私有静态变量。
 *
 * 实例锁：锁住非静态方法  锁住this  锁住非静态变量
 * 类 锁： 锁住Class(ClassName.class)  锁住静态变量  锁住静态方法
 **/
//懒汉式
//线程不安全
public class Lazybones {
	//以下实现中，私有静态变量 uniqueInstance 被延迟实例化，
	// 这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，
	// 从而节约资源。
	private static Lazybones uniqueZInstance;

	private Lazybones() {
	}

	//这个实现在多线程环境下是不安全的，
	// 如果多个线程能够同时进入 if (uniqueInstance == null) ，
	// 并且此时 uniqueInstance 为 null，
	// 那么会有多个线程执行 uniqueInstance = new Singleton();
	// 这将导致多次实例化 uniqueInstance。
	public static Lazybones getUniqueZInstance() {
		if (uniqueZInstance == null) {
			uniqueZInstance = new Lazybones();
		}
		return uniqueZInstance;
	}
}

//线程安全
class LazybonesSynchronized {
	private static LazybonesSynchronized uniqueZInstance;

	private LazybonesSynchronized() {
	}

	//那么在一个时间点只能有一个线程能够进入该方法，
	// 从而避免了多次实例化 uniqueInstance 的问题。
	//但是当一个线程进入该方法之后，
	// 其它试图进入该方法的线程都必须等待，
	// 因此性能上有一定的损耗。

	//类锁：锁住静态方法  （还有：锁住类   锁住静态变量）
	public static synchronized LazybonesSynchronized getUniqueZInstance() {
		if (uniqueZInstance == null) {
			uniqueZInstance = new LazybonesSynchronized();
		}
		return uniqueZInstance;
	}
}

//线程安全，双重校验锁
class LazybonesDoubleCheckLock {
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

	private volatile static LazybonesDoubleCheckLock uniqueZInstance;

	private LazybonesDoubleCheckLock() {}

	//双重校验锁先判断 uniqueInstance 是否已经被实例化，
	// 如果没有被实例化，那么才对实例化语句进行加锁。
	public static LazybonesDoubleCheckLock getUniqueZInstance() {
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
				当一个线程获取了 LazybonesDoubleCheckLock.class 的锁后，
				其他任何试图进入同一类的 synchronized (LazybonesDoubleCheckLock.class)
				代码块的线程都会被阻塞。
				这也意味着，使用类锁时，锁的范围是整个类，而不仅仅是某个实例，
				因此这种锁通常用于需要确保对类级别的资源（如静态变量）进行同步访问的情况。
			应用场景：
				类锁通常用于控制对静态变量的访问，因为静态变量属于类而不是某个实例。
				适用于单例模式中，确保在并发环境下只有一个实例被创建。
			 */
			//类锁：锁住当前类  （锁住静态方法  锁住静态变量）
			synchronized (LazybonesDoubleCheckLock.class) {
				if(uniqueZInstance == null) {
					uniqueZInstance = new LazybonesDoubleCheckLock();
				}
			}
		}
		return uniqueZInstance;
	}
}

//静态内部类实现
//当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。
// 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时
// SingletonHolder 才会被加载，此时初始化 INSTANCE 实例。
// 这种方式不仅具有延迟初始化的好处，而且由虚拟机提供了对线程安全的支持。
class LazyBonesStaticInnerClass {
	private LazyBonesStaticInnerClass(){}

	private static class SingletonHolder {
		private static final LazyBonesStaticInnerClass INSTANCE = new LazyBonesStaticInnerClass();
	}
	public static LazyBonesStaticInnerClass getUniqueInstance() {
		return SingletonHolder.INSTANCE;
	}
}

//TODO 枚举实现 单例模式的最佳实践
// 实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次。
enum Singleton {
	uniqueInstance;
}
//考虑以下单例模式的实现，该 Singleton 在每次序列化的时候都会创建一个新的实例，
// 为了保证只创建一个实例，必须声明所有字段都是 transient，并且提供一个 readResolve() 方法。

//如果不使用枚举来实现单例模式，会出现反射攻击，
// 因为通过 setAccessible() 方法可以将私有构造函数的访问级别设置为 public，
// 然后调用构造函数从而实例化对象。如果要防止这种攻击，
// 需要在构造函数中添加防止实例化第二个对象的代码。
class SingletonEnum implements Serializable {
	private static SingletonEnum uniqueInstance;
	private SingletonEnum(){}

	public static synchronized SingletonEnum getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SingletonEnum();
		}
		return uniqueInstance;
	}
}
