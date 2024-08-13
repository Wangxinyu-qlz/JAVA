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