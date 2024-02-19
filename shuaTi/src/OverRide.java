/*
考察点1：重载静态多分派——根据传入重载方法的参数类型，选择更加合适的一个重载方法

考察点2：static方法不能被子类覆写，在子类中定义了和父类完全相同的static方法，则父类的static方法被隐藏
		Son.staticmethod()或new Son().staticmethod()都是调用的子类的static方法
		如果是Father.staticmethod()或者Father f = new Son(); f.staticmethod()调用的都是父类的static方法。

考察点3：此题如果都不是static方法，则最终的结果是A. 调用子类的getType，输出Sub Sub Sub

 */
import java.util.*;

public class OverRide {
	public static void main(String[] args) {
		Super super_ = new Sub();
		Sub sub_ = (Sub)super_;
		//TODO 显式的区分了父类和子类中的属性，向下转型之后，sub_既可以调用自己的，又可以调用父类的
		//super_.super_i=1super_.sub_i=编译错误，不存在super_.sub_i
		System.out.println("super_.super_i=" + super_.super_i + "super_.sub_i=编译错误，不存在super_.sub_i");
		//sub_.sub_i=2sub_.super_i=1
		System.out.println("sub_.sub_i=" + sub_.sub_i + "sub_.super_i=" + sub_.super_i);

		//不显式区分父类和子类中的属性，向下转型之后，sub_调用的属性就是子类（Sub）的
		System.out.println(super_.i);//1
		System.out.println(sub_.i);//2


		Collection<?>[] collections =
				{new HashSet<String>(), new ArrayList<String>(), new HashMap<String, String>().values()};

		/*
			static方法不能被子类覆写
			Super:collection
			Super:collection
			Super:collection
		 */
		/*
			如果都不是static方法则输出
			Sub
			Sub
			Sub
		 */
		Super subToSuper = new Sub();
		for (Collection<?> collection : collections) {
			System.out.println(subToSuper.getType(collection));//
		}
		/*
			Super:collection
			Super:collection
			Super:collection
		 */
		Super aSuper = new Super();
		for (Collection<?> collection : collections) {
			System.out.println(aSuper.getType(collection));//
		}

		/*
			Sub
			Sub
			Sub
		 */
		Sub aSub = new Sub();
		for (Collection<?> collection : collections) {
			System.out.println(aSub.getType(collection));//
		}
	}

	 static class Super {
		public int super_i = 1;
		public int i = 1;
		public  static String getType(Collection<?> collection) {
			return "Super:collection";
		}

		public static String getType(List<?> list) {
			return "Super:list";
		}

		public String getType(ArrayList<?> list) {
			return "Super:arrayList";
		}

		public static String getType(Set<?> set) {
			return "Super:set";
		}

		public String getType(HashSet<?> set) {
			return "Super:hashSet";
		}
	}

	static class Sub extends Super {
		public int sub_i=2;
		public int i = 2;
		public static String getType(Collection<?> collection) {
			return "Sub";
		}
	}
}
