package class_;
/**
 * @author qiaolezi
 * @version 1.0
 */
public class GetClass_ {
	public static void main(String[] args) throws Exception {
		//1. Class.forName
		String classAllPath = "class_.Car";//通过配置文件参数获取
		Class<?> cls1 = Class.forName(classAllPath);
		System.out.println(cls1);//class class_.Car

		//2. 类名.class  应用场景：参数传递（eg:通过反射得到构造器）
		Class cls2 = Car.class;
		System.out.println(cls2);//class class_.Car

		//3. 对象.getClass()  应用场景：有对象实例
		Car car = new Car();
		Class<? extends Car> cls3 = car.getClass();
		System.out.println(cls3);//class class_.Car

		//4. 通过类加载器[4种]获取类的Class对象
		//(1)先得到类加载器 car
		ClassLoader classLoader = car.getClass().getClassLoader();
		//(2)通过类加载器得到Class对象
		Class<?> cls4 = classLoader.loadClass(classAllPath);
		System.out.println(cls4);//class class_.Car

		//cls1 cls2 cls3 cls4 其实是同一个对象
		System.out.println(cls1.hashCode());//460141958
		System.out.println(cls2.hashCode());//460141958
		System.out.println(cls3.hashCode());//460141958
		System.out.println(cls4.hashCode());//460141958

		//5.基本数据类型（int, char, boolean, float, double, byte, long, short）按照如下方式得到Class对象
		Class<Integer> integerClass = int.class;//自动装箱 拆箱
		Class<Character> characterClass = char.class;
		Class<Boolean> booleanClass = boolean.class;
		System.out.println(integerClass);//int

		//6.基本数据类型对象的包装类，通过 .TYPE 得到Class类对象
		Class<Integer> type = Integer.TYPE;
		Class<Character> type1 = Character.TYPE;
		System.out.println(type);//int

		System.out.println(integerClass.hashCode());//1163157884
		System.out.println(type.hashCode());//1163157884
	}
}
