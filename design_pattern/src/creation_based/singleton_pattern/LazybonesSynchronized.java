package creation_based.singleton_pattern;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:52
 * @description:
 **/
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