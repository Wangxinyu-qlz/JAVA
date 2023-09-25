/**
 * @author qiaolezi
 * @version 1.0
 */
public class Generic03 {
	public static void main(String[] args) {
		Person<String> person = new Person<String>("qwer");
		person.showClass();//class java.lang.String
		/*
		* class Person<String> {
			String s;

			public Person(String s) {
				this.s = s;
			}

			public String f() {
				return s;
			}
		}
		* */
	}
}

//泛型的作用：可以在类声明时通过一个标识表示
//1.类中某个属性的类型
//2.某个方法的返回值的类型
//3.参数类型
class Person<E> {
//	E 表示 s 的数据类型，该数据类型在定义 Person 对象的时候指定，即在编译期间就确定 E 是什么类型
	E s;

	public Person(E s) {
		this.s = s;
	}

	public E f() {
		return s;
	}

	public void showClass() {
		System.out.println(s.getClass());//获得s的运行类型
	}
}
