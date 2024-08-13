package creation_based.singleton_pattern;

import java.io.Serializable;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:53
 * @description:
 **/
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
