/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-04 13:38
 * @description:
 * 最近学习继承，从书中看到子类继承父类，子类拥有父类所有的属性和方法，于是使用程序去验证，发现父类的私有属性和私有方法，子类是不能访问的，
 * 当然一些父类的私有属性可能可以通过相应的方法访问到，但是私有的方法似乎不能简单的访问，这里暂不考虑Java反射机制，于是我分析，
 * 子类不能继承父类私有的属性及方法，但是分析了内存后，我发现我是错的，在一个子类被创建的时候，首先会在内存中创建一个父类对象，
 * 然后在父类对象外部放上子类独有的属性，两者合起来形成一个子类的对象。所以所谓的继承使子类拥有父类所有的属性和方法其实可以这样理解，
 * 子类对象确实拥有父类对象中所有的属性和方法，但是父类对象中的私有属性和方法，子类是无法访问到的，只是拥有，但不能使用。
 * 就像有些东西你可能拥有，但是你并不能使用。所以子类对象是绝对大于父类对象的，所谓的子类对象只能继承父类非私有的属性及方法的说法是错误的。
 * 可以继承，只是无法访问到而已。
 *
 * 当子类覆盖父类的成员变量时，父类方法使用的是父类的成员变量，子类方法使用的是子类的成员变量
 *
 *  1.子类覆盖父类的方法，必须有同样的参数返回类型，否则编译不能通过
 *  2.子类覆盖父类的方法，在jdk1.5后，参数返回类可以是父类方法返回类的子类
 *  3.子类覆盖父类方法，可以修改方法作用域修饰符，但只能把方法的作用域放大，而不能把public修改为private
 *  4.子类方法能够访问父类的protected作用域成员，不能够访问默认的作用域成员,除非子类与父类同包
 *  5.子类的静态方法不能隐藏同名的父类实例方法
 *
 * 子类不能直接访问父类的私有属性，子类只能在父类中写一个public的getXXX的方法来获取父类中的private属性，
 * 子类就调用父类的getXXX来获取private属性
 * 父类中的公有方法和域(属性)，在类继承中将会被子类继承，但是私有的将不能被继承。
 *
 * 那么在继承中子类如何才能继承到父类的私有域呢？
 * 答案是：在子类的构造方法中通过super()方法调用父类的构造方法。
 * 也就是，在构造子类的同时，为子类构造出跟父类相同的域。如此就在子类的对象中，也拥有了父类声明的域了。
 **/

public class Person {
	private String name;
	private Integer age;

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

class Student extends Person {
	//TODO 继承父类后，至少需要有一个和父类构造器参数相同的构造器
	public Student(String name) {
		super(name);
	}
}


class TestStudent {
	public static void main(String[] args) {
		//通过super(String name) 继承了父类的私有域
		Student mStudent = new Student("abc");
		String mName = mStudent.getName();
		System.out.println("Name is : " + mName);//abc

		mStudent.setName("efg");
		mName = mStudent.getName();
		System.out.println("Name is : " + mName);//ef
	}
}