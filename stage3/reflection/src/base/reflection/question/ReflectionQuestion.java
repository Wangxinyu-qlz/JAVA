package base.reflection.question;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ReflectionQuestion {
	@SuppressWarnings({"all"})
	public static void main(String[] args) throws Exception {
		//根据配置文件的 reflection.properties 指定信息，创建 Cat 对象并调用方法 hi

		//传统方法
		//Cat cat = new Cat();
		//cat.hi();

		//反射 reflection
		//1.使用Properties类读取配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\My_Code\\Java\\stage3\\reflection\\src\\reflection.properties"));
		String classfullpath = properties.get("classfullpath").toString();
		String methodName = properties.get("method").toString();
		System.out.println("classfullpath=" + classfullpath + "  method=" + methodName);//classfullpath=base.Cat  method=hi

		//2.创建对象
		//new classfullpath//Error

		//3.反射机制
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
	}
}
