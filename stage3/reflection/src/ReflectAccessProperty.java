import java.lang.reflect.Field;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ReflectAccessProperty {
	public static void main(String[] args) throws Exception {
		//1.得到Student对象对应的Class对象
		Class<?> stuClass = Class.forName("Student");
		//2.创建对象
		Object object = stuClass.newInstance();//object的运行类型是Student
		System.out.println(object.getClass());//class Student
		//3.使用反射得到age属性  对象
		Field age = stuClass.getField("age");
		age.set(object, 88);//通过反射操作属性
		System.out.println(object);//student [age=88, name=null]
		System.out.println(age.get(object));//88

		//4.使用反射操作name属性
		Field name = stuClass.getDeclaredField("name");
		name.setAccessible(true);//TODO 爆破
		name.set(object, "王天一");
		System.out.println(object);//student [age=88, name=王天一]
		name.set(null, "大胆");//TODO name是静态的属性，object可以写成null
		System.out.println(object);//student [age=88, name=大胆]
		System.out.println(name.get(null));//大胆，要求name属性是静态的

	}
}

class Student {
	public int age;
	private static String name;

	public Student() {//构造器

	}
	public String toString() {
		return "student [age=" + age + ", name=" + name + "]";
	}
}