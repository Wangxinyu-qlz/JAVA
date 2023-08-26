/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork01 {
	public static void main(String[] args) {
		Car c = new Car();
		Car c1 = new Car(100);
		System.out.println(c);//9.0  red
		System.out.println(c1);//100.0  red
	}
}

class Car {
	double price = 10;
	static String color = "white";//TODO 只会在类加载时，初始化一次

	public String toString() {
		return price + "\t" + color;
	}

	public Car() {
		this.price = 9;
		this.color = "red";
	}

	public Car(double price) {
		this.price = price;
	}
}
