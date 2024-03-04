package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 17:57
 * @description:
 **/
public class JavaJson {
	public static void main(String[] args) {
		Gson gson = new Gson();
		//演示JavaBean和Json字符串的转换
		Book hello = new Book(100, "hello");

		String jsonHello = gson.toJson(hello);
		System.out.println(jsonHello);//{"id":100,"name":"hello"}

		//jsonHello:字符串  Book.Class:要转成 BOOK 对象
		//底层是反射机制
		Book bookHello = gson.fromJson(jsonHello, Book.class);
		System.out.println(bookHello);//Book{id=100, name='hello'}

		//List对象 -> json字符串
		ArrayList<Book> bookArrayList = new ArrayList<>();
		bookArrayList.add(new Book(200, "1"));
		bookArrayList.add(new Book(300, "300"));
		String jsonBookList = gson.toJson(bookArrayList);
		System.out.println(jsonBookList);//[{"id":200,"name":"1"},{"id":300,"name":"300"}]

		//json字符串 -> List对象
		//TypeToken，是一个自定义泛型，通过TypeToken指定需要转换成的类型
		/**
		 * public class TypeToken<T> {
		 *     final Class<? super T> rawType;
		 *     final Type type;
		 *     final int hashCode;
		 *
		 *     protected TypeToken() {
		 *         this.type = getSuperclassTypeParameter(this.getClass());
		 *         this.rawType = Types.getRawType(this.type);
		 *         this.hashCode = this.type.hashCode();
		 *     }
		 *
		 *     TypeToken(Type type) {
		 *         this.type = Types.canonicalize((Type)Preconditions.checkNotNull(type));
		 *         this.rawType = Types.getRawType(this.type);
		 *         this.hashCode = this.type.hashCode();
		 *     }
		 */
		//返回类型的完整路径：List类的和BOOK类的
		//完整路径->反射
		//为什么需要{}
		//TypeToken的无构造器是protected，而new TypeToken<List<Book>>()就是调用其无参构造器
		//根据protected关键字的特性，无法直接访问（实例化）
		//new TypeToken<List<Book>>() {}    匿名内部类，不是TypeToken，可理解为是TypeToken的子类
		//而且该匿名内部类 有自己的无参构造器（隐式），根据Java基础规则，当执行子类的无参构造器时，默认有super();
		//寻找父类（TypeToken）的无参构造器
		//
		Type type = new TypeToken<List<Book>>() {}.getType();
		System.out.println("type=" + type);//type=java.util.List<json.Book>
		System.out.println(type.getClass());//class com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl
		List<Book> arrayListBook = gson.fromJson(jsonBookList, type);
		System.out.println(arrayListBook);//[{id=200.0, name=1}, {id=300.0, name=300}]
	}
}