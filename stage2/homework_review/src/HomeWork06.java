/**
 * @author qiaolezi
 * @version 1.0
 * 编程思想：工厂模式
 * 始终只使用一匹马
 */
public class HomeWork06 {
	public static void main(String[] args) {
		Person tang = new Person("tang", new Horse());
		tang.common();
		tang.passRiver();
		tang.common();
		tang.common();
		tang.common();
		tang.passRiver();
		tang.common();
		tang.passRiver();
	}
}

interface Vehicles {
	void work();
}

//要求始终是同一匹马，任务应该交给VehiclesFactory，因为它是生产马的工厂
class Horse implements Vehicles {
//	private Horse() {}
//	public static Horse getHorse() {
//		return new Horse();
//	}
	public void work() {
		System.out.println("用马");
	}
}

class Boat implements Vehicles {
	public void work() {
		System.out.println("用船");
	}
}

class VehiclesFactory {
	private VehiclesFactory() {}
	private static Horse horse = new Horse();//TODO 注意这里的修饰符：private static
	public static Horse getHorse (){
		return horse;
	}

	public static Boat getBoat () {
		return new Boat();
	}
}

class Person {
	private String name;
	private Vehicles vehicles;

	public Person(String name, Vehicles vehicles) {
		this.name = name;
		this.vehicles = vehicles;
	}

	public void common() {
		if(!(vehicles instanceof Horse)) {
			VehiclesFactory.getHorse();
		}
		vehicles.work();
	}

	public void passRiver() {
		if(!(vehicles instanceof Boat)) {
			VehiclesFactory.getBoat();
		}
		vehicles.work();
	}
}