import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ReflectionUtils {
	public static void main(String[] args) {

	}

	//第一组方法API
	@Test
	public void api01() throws Exception {
		//得到CLass对象
		Class<?> cls = Class.forName("Person");
		//getName:获取全类名
		System.out.println(cls.getName());//路径.类名
		//getSimpleName:获取简单类名
		System.out.println(cls.getSimpleName());//只有类名
		//getFields:获取所有public修饰的属性，包括本类以及父类的
		Field[] fields = cls.getFields();
		for (Field field : fields) {
			System.out.println("本类及父类的public属性" + field.getName());//name hobby
		}
		//getDeclaredFields:获取本类中所有属性
		Field[] declaredField = cls.getDeclaredFields();
		for (Field field : declaredField) {
			System.out.println("本类的所有属性" + field.getName());//name age job sal
		}
		//getMethods:获取所有public修饰的方法，包含本类的以及父类的
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			/*
				本类及父类的public方法m1
				本类及父类的public方法wait
				本类及父类的public方法wait
				本类及父类的public方法wait
				本类及父类的public方法equals
				本类及父类的public方法toString
				本类及父类的public方法hashCode
				本类及父类的public方法getClass
				本类及父类的public方法notify
				本类及父类的public方法notifyAll
			 */
			System.out.println("本类及父类的public方法" + method.getName());
		}
		//getDeclaredMethods:获取本类的所有方法
		Method[] declaredMethods = cls.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println("本类的所有方法" + declaredMethod.getName());
		}
		//getConstructors:获取所有的public构造器，只有本类的
		Constructor<?>[] constructors = cls.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("本类的构造器" + constructor.getName());//Person  Person
		}
		//getDeclaredConstructors:获取所有的public构造器，包含本类及父类的
		Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			System.out.println("本类所有的构造器" + declaredConstructor.getName());//Person  Person  Person
		}
		//getPackage:以Package形式返回包信息
		System.out.println(cls.getPackage());//null  这个类没有在包里
		//getSuperClass:以Class返回父类信息
		Class<?> superclass = cls.getSuperclass();
		System.out.println(superclass);//class A
		//getInterfaces:以Class[]形式返回接口信息
		Class<?>[] interfaces = cls.getInterfaces();
		for (Class<?> anInterface : interfaces) {
			System.out.println("接口信息" + anInterface.getName());//IA  IB
		}
		//getAnnotations:以Annotations[]形式返回注解信息
		Annotation[] annotations = cls.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("注解信息" + annotation);//@java.lang.Deprecated()
		}
	}

	//第二组方法API
	@Test
	public void api02() throws Exception {
		//得到CLass对象
		Class<?> cls = Class.forName("Person");
		//getDeclaredFields:获取本类中所有属性
		Field[] declaredField = cls.getDeclaredFields();
		for (Field field : declaredField) {
			/*
				本类的所有属性name该属性的修饰符值=1  (public)
				本类的所有属性age该属性的修饰符值=12   (8+4 = protected static)
				本类的所有属性job该属性的修饰符值=0   (默认的修饰符)
				本类的所有属性sal该属性的修饰符值=2   (private)
											8    (static)
				                            16   (final)
			 */
			System.out.println("本类的所有属性" + field.getName() +
					"该属性的修饰符值=" + field.getModifiers() +
					"该属性的类型=" + field.getType());
		}

		//getDeclaredMethods:获取本类的所有方法
		Method[] declaredMethods = cls.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println("本类的所有方法" + declaredMethod.getName() +
					"该方法的访问修饰符：" + declaredMethod.getModifiers() +
					"该方法的返回类型：" + declaredMethod.getReturnType());
			//输出当前这个方法的形参数组情况
			Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("\t该方法的形参类型：" + parameterType.getName());
			}
		}

		//getDeclaredConstructors:获取所有的public构造器，包含本类及父类的
		Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			System.out.println("本类所有的构造器" + declaredConstructor.getName());//Person  Person  Person
			Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("该构造器的形参类型：" + parameterType.getName());
			}
		}

	}
}

class A {
	public String hobby;
	public A() {}
}
interface IA {}
interface IB {}
@Deprecated
class Person extends A implements IA,IB {
	//属性
	public String name;
	protected static int age;
	String job;
	private double sal;

	public Person() {}
	public Person(String name) {}
	private Person(String name, int age) {}
	//方法
	public void m1(String name, int age, double salary) {

	}
	protected String m2() {
		return null;
	}
	void m3() {

	}
	private void m4() {

	}
}
