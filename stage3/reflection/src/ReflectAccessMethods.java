import java.lang.reflect.Method;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ReflectAccessMethods {
	public static void main(String[] args) throws Exception {
		//1.得到Boss类对应的Class对象
		Class<?> bossClass = Class.forName("Boss");
		//2.创建实例
		Object object = bossClass.newInstance();
		//3.调用public的hi方法
		Method hi = bossClass.getMethod("hi", String.class);
		hi.invoke(object, ".");

		//调用private static 方法
		Method declaredMethod = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
		declaredMethod.setAccessible(true);//TODO 爆破
		//TODO 方法统一返回Object 但是运行类型和方法定义类型一致
		Object invoke = declaredMethod.invoke(null, 1, "我是", '天');
		System.out.println(invoke);

	}
}

class Boss {
	public int age = 36;
	public static String name = "傻福";
	public Boss() {//构造器
	}

	private static String say(int n, String s, char c) {
		return s + " " + n + " " + c + "qwe";
	}

	public void hi(String s) {
		System.out.println("嗨嗨" + s);
	}
}