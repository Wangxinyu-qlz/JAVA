import java.lang.reflect.Constructor;

/**
 * @author qiaolezi
 * @version 1.0
 * 通过反射机制创建实例
 */
public class ReflectCreateInstance {
	public static void main(String[] args) throws Exception {
		Class<?> userClass = Class.forName("User");
		//1.通过public的无参构造器创建实例
		Object object = userClass.newInstance();
		System.out.println(object);//User{age=10, name='qwe'}

		//2.通过public的有参构造器创建实例
		/*
		constructor对象是：
				public User(String name) {this.name = name;}
		 */
		//(1)先得到对应的构造器
		Constructor<?> constructor = userClass.getConstructor(String.class);
		//(2)创建实例并传入实参
		Object object1 = constructor.newInstance("123");//重新传入变量值
		System.out.println(object1);//User{age=10, name='123'}

		//3.通过非public的有参构造器创建实例
		Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);//私有的
		declaredConstructor.setAccessible(true);//爆破，使用反射可以访问private的构造器
		Object object2 = declaredConstructor.newInstance(11, "王一一");
		System.out.println(object2);//User{age=11, name='王一一'}
	}
}

class User {
	private int age = 10;
	private String name = "qwe";

	public User() {}

	public User(String name) {
		this.name = name;
	}

	private User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}