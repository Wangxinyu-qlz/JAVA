import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Exception04_Throws {
	public static void main(String[] args) {

	}

	public static void f2() {
//		f3();//Error：f3()将异常抛给了调用者，这里必须显式处理f3()的 TODO 编译异常
//		throws/try-catch

		try {
			f3();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void f3() throws FileNotFoundException{
		FileInputStream file = new FileInputStream("C://aa.txt");
	}

	public void f4() {
		f5();//OK TODO 运行异常，不必显式处理
	}

	public void f5() throws ArithmeticException{

	}
/*
* Details：
* 1.对于编译异常，程序必须处理
* 2.对于运行异常，程序中没有处理，默认使用throws处理（给调用者-->JVM）
* 3.子类重写父类方法时，或抛出异常和父类抛出异常一致，或是父类抛出异常的子类
* 4.try-catch和throws二选一
* */
	public void f1() throws FileNotFoundException,NullPointerException{//可以使它的父类：Exception
/*
		创建一个文件流
		处理异常
		1.使用try-catch-finally
		2.使用throws 抛出异常
		让调用f1()的调用者处理
		throws 关键字之后可以使一个列表，即抛出多个异常
		try {
			FileInputStream file = new FileInputStream("C://aa.txt");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
*/
		FileInputStream file = new FileInputStream("C://aa.txt");
	}
}

class Father {
	public void method() throws RuntimeException {

	}
}

class Son extends Father {
	@Override
	public void method() throws NullPointerException {

	}
}