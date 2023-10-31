package class_;
import base.Cat;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Class01 {
	public static void main(String[] args) throws Exception {
		//看看Class类图
		//1. Class也是类，继承Object类
		//2. Class类对象不是new出来的，而是系统创建的
		//（1）传统 new 对象
		/* ClassLoader类
		    public Class<?> loadClass(String name) throws ClassNotFoundException {
		        return loadClass(name, false);
		    }
		 */
		Cat cat = new Cat();

		//反射方式
		//TODO Cat cat = new Cat();存在时，不会deBug到ClassLoader类的 loadClass，类只加载一次
		/*ClassLoader类
		    public Class<?> loadClass(String name) throws ClassNotFoundException {
		        return loadClass(name, false);
		    }
		 */
		Class<?> aClass1 = Class.forName("base.Cat");
		Class<?> aClass2 = Class.forName("base.Cat");
		System.out.println(aClass1.hashCode() + "   " + aClass2.hashCode());//460141958   460141958
	}
}
