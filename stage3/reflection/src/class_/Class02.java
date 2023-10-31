package class_;
import java.lang.reflect.Field;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Class02 {
	public static void main(String[] args) throws Exception {
		String classAllPath = "class_.Car";
		//获取Cat类对应的 Class 对象
		//<?>表示不确定的 Java 类型
		Class<?> aClass = Class.forName(classAllPath);

		System.out.println(aClass);//显示aClass对象是哪个类的Class对象  class class_.Car
		System.out.println(aClass.getClass());//显示aClass的运行类型   class java.lang.Class

		//得到包名
		System.out.println(aClass.getPackage().getName());//class_

		//全类名
		System.out.println(aClass.getName());//class_.Car

		//通过aClass创建对象实例
		Car car = (Car) aClass.newInstance();
		System.out.println(car);//Car{brand='宝马', price=50000, color='白色'}

		//通过aClass获得属性
		Field brand = aClass.getField("brand");
		System.out.println(brand);//public java.lang.String class_.Car.brand
		System.out.println(brand.get(car));//宝马

		//通过反射给属性赋值
		brand.set(car, "丰田");
		System.out.println(brand.get(car));//丰田

		//获得所有的属性
		Field[] fields = aClass.getFields();
		for (Field f: fields) {
			System.out.println(f.getName());//brand  price  color
			System.out.println(f.get(car));//丰田  50000  白色
		}
	}
}
