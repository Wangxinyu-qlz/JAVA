import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Reflection01 {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\My_Code\\Java\\stage3\\reflection\\src\\reflection.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String methodName = properties.get("method").toString();

		//反射机制
		//(1)加载类,返回Class类型的对象
		Class<?> aClass = Class.forName(classfullpath);
		//(2)通过aClass得到base.Cat的对象实例
		Object object = aClass.newInstance();
		System.out.println(object.getClass());//class base.Cat
		//(3)通过aClass得到加载的类 base.Cat 的methodName"hi" 的方法对象
		//    即：在反射中，可以将方法是为对象（万物皆对象）
		Method method = aClass.getMethod(methodName);
		//(4)通过method1调用方法：即通过方法对象来实现调用方法
		method.invoke(object);//传统方法 对象.方法()《《《》》》反射机制 方法.invoke(对象)

		//field 成员变量
		//getField不能得到私有属性
		Field nameField = aClass.getField("age");
		System.out.println(nameField.get(object));//传统方法 对象.成员变量 《《《》》》反射 成员变量对象.get(对象)

		Constructor<?> constructor = aClass.getConstructor();//()中可以指定构造器的参数类型，这里返回无参构造器
		System.out.println(constructor);//public base.Cat()

		Constructor<?> constructor1 = aClass.getConstructor(String.class);
		System.out.println(constructor1);//public base.Cat(java.lang.String)
	}
}
