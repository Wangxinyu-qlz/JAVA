import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class ObjectInputStream_ {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String filePath = "C:\\My_Code\\Java\\stage2\\file\\data.dat";

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

//		读取数据
//		TODO 读取的顺序（反序列化）需要和保存的数据（序列化）顺序一致
//		否则会抛出异常
		System.out.println(objectInputStream.readInt());
		System.out.println(objectInputStream.readBoolean());
		System.out.println(objectInputStream.readChar());
		System.out.println(objectInputStream.readDouble());
		System.out.println(objectInputStream.readUTF());
		Object dog = objectInputStream.readObject();
		System.out.println("o的运行类型是：" + dog.getClass());
		System.out.println(dog);//Object -> Dog
		System.out.println("dog信息：" + dog);

//		TODO 这里有特别重要的细节
//		1.如果我们需要调用Dog的方法，需要向下转型
//		TODO 2.需要将Dog类的定义，拷贝到可以引用的位置，否则不能转型
//		将Dog类做成公共的 public
		Dog dog1 = (Dog) dog;


//		关闭流
		objectInputStream.close();
	}
}
