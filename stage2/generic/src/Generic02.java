import java.util.ArrayList;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Generic02 {
	public static void main(String[] args) {
		Dog dog1 = new Dog("大", 5);
		Dog dog2 = new Dog("小", 1);
		Dog dog3 = new Dog("点点", 3);
//		public class ArrayList<E>  Dog->E
		ArrayList<Dog> arrayList = new ArrayList<Dog>();
		arrayList.add(dog1);
		arrayList.add(dog2);
		arrayList.add(dog3);
//		解决方案：使用泛型 generic
//		arrayList.add(new Cat("毛毛", 2));//编译错误，arrayList中只允许存放Dog类型

//		遍历时，可以直接取出Dog类型
		System.out.println("+++++++使用泛型遍历++++++++");
		for (Dog dog : arrayList) {
			System.out.println(dog.getAge() + "-" + dog.getName());
		}
	}
}
