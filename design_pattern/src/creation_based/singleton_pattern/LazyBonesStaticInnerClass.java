package creation_based.singleton_pattern;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:50
 * @description:
 **/
//静态内部类实现
//当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。
// 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时
// SingletonHolder 才会被加载，此时初始化 INSTANCE 实例。
// 这种方式不仅具有延迟初始化的好处，而且由虚拟机提供了对线程安全的支持。
public class LazyBonesStaticInnerClass {
	private LazyBonesStaticInnerClass(){}

	private static class SingletonHolder {
		private static final LazyBonesStaticInnerClass INSTANCE = new LazyBonesStaticInnerClass();
	}
	public static LazyBonesStaticInnerClass getUniqueInstance() {
		return SingletonHolder.INSTANCE;
	}
}