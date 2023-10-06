import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ObjectOutputStream_ {
	public static void main(String[] args) throws Exception {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\data.dat";

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

//		序列化数据到 "C:\\My_Code\\Java\\stage2\\file\\data.dat" 中
		objectOutputStream.writeInt(100);//int -> Integer(实现了Serializable接口)
		objectOutputStream.writeBoolean(true);//boolean -> Boolean(实现了Serializable接口)
		objectOutputStream.writeChar('a');//char -> Character(实现了Serializable接口)
		objectOutputStream.writeDouble(9.3);//double -> Double(实现了Serializable接口)
		objectOutputStream.writeUTF("来网了");//String

//		保存一个Dog对象
		objectOutputStream.writeObject(new Dog("旺财", 2, "如本", "黑色"));

		objectOutputStream.close();
		System.out.println("数据保存完毕！");
	}
}

//序列化具有继承性，一个类实现了Serializable接口，其子类也会可以序列化
class Dog implements Serializable {
//	TODO serialVersionUID 序列化的版本号，可以提高序列化的兼容性
//	如果加入新的属性，在序列化反序列化时，不会认为是一个新的类，而是同一个类的版本升级
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String hobby;
//	TODO 序列化对象时，默认将类中所有的属性都进行序列化，但除了static或transient修饰的成员
//	Dog{name='旺财', age=2, hobby='null', color='null'}
	private static String nation;
	private transient String color;//短暂的暂时的

//	属性也要实现 Serializable 接口
	private Master master = new Master();

	public Dog(String name, int age, String nation, String color) {
		this.name = name;
		this.age = age;
		this.nation = nation;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				", hobby='" + hobby + '\'' +
				", color='" + color + '\'' +
				", master=" + master +
				'}';
	}
}

class Master implements Serializable {

}