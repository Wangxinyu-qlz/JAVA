/**
 * @author qiaolezi
 * @version 1.0
 */
public class CustomMethodGeneric {
	public static void main(String[] args) {
		Car car = new Car();
		car.fly("宝马", 100.0);//调用方法时，传入参数，编译器会确定类型
		car.fly(300.0, 100);
	}
}

class Car {
	public void run() {

	}

//	<T, R> 是泛型标识符
	public <T, R> void fly(T t, R r) {//泛型方法
		System.out.println(t.getClass());//String
		System.out.println(r.getClass());//Double
	}
}

class Fish<T, R> {
	public void run() {

	}

	public<U, N> void eat(U u, N n) {}//泛型方法

//	hi()不是泛型方法
//	只是使用了类声明的泛型
	public void hi(T t) {

	}
}
