/*
	方法引用

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionCitation {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();

		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		names.add("F");

		//将System.out::println 方法作为静态方法来引用
		names.forEach(System.out::println);

		//构造器引用：它的语法是Class::new，或者更一般的Class< T >::new
		final Car car = Car.create(Car::new);
		final List<Car> cars = Arrays.asList(car);

		//	静态方法引用：它的语法是Class::static_method
		cars.forEach(Car::collide);

		//特定类的任意对象的方法引用：它的语法是Class::method
		cars.forEach(Car::repair);

		//特定对象的方法引用：它的语法是instance::method
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);

		final Car car1 = Car.create(Car::new);
		List<Car> carslist = new ArrayList<>();
		carslist.add(car);
		carslist.add(car1);
		carslist.forEach(Car::collide);//将列表中的每个car都进行collide操作
		//等效操作
		for (Car acar : carslist) {
			Car.collide(acar);
		}

		System.out.println("-----------------------");
		cars.forEach(System.out::println);//Car@7ba4f24f
		System.out.println(car);//Car@7cca494b
		System.out.println(car);//Car@7cca494b
		System.out.println(cars);//[Car@7cca494b]
		System.out.println(cars == car);//false
		Car car3 = new Car();
		car3.follow(car);


	}

}

@FunctionalInterface
interface Supplier<T> {
	T get();
}

class Car {
	//Supplier是jdk1.8的接口，这里和lamda一起使用了
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
}
