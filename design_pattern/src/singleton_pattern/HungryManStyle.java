package singleton_pattern;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:59
 * @description: 饿汉式：依赖JVM类加载机制，保证单例只被创建一次
 * 线程安全，初始化速度快，占用内存少
 **/
public class HungryManStyle {
	private static HungryManStyle uniqueInstance = new HungryManStyle();
	private HungryManStyle(){}

	public static HungryManStyle getUniqueInstance() {
		return uniqueInstance;
	}
}
