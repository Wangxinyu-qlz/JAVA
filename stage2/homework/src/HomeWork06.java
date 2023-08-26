/**
 * @author qiaolezi
 * @version 1.0
 * TODO 多看多想 工厂模式 细节 值得多琢磨
 * 1.有一个交通工具接口类Vehicles,有work接口
 * 2.有Horse类和Boat类分别实现Vehicles
 * 3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
 * 4.有Person类，有name和Vehicles)属性，在构造器中为两个属性赋值
 * 5.实例化Person对像“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
 * 6.增加一个情况，过火焰山用飞机，====>>>增加程序的扩展性  这个程序结构很好扩展
 */
public class HomeWork06 {
	public static void main(String[] args) {
		Person p = new Person("唐僧", new Horse());
		p.pasRiver();
		p.pass();
		p.passFire();
	}
}

interface Vehicles {
	void work();
}

class VehiclesFactory {
//	始终是同一匹马
	private static Horse horse = new Horse();
	private VehiclesFactory() {}
	public static Horse getHorse() {
//		return new Horse();
		return horse;
	}

	public static Boat getBoat() {
		return new Boat();
	}

	public static Plane getPlane() {
		return new Plane();
	}
}

class Horse implements Vehicles{
	public void work() {
		System.out.println("用马");
	}
}

class Boat implements Vehicles{
	public void work() {
		System.out.println("用船");
	}
}

class Plane implements Vehicles {
	public void work() {
		System.out.println("坐飞机");
	}
}

class Person {
	private String name;
	private Vehicles v;

	public Person(String name, Vehicles v) {
		this.name = name;
		this.v = v;
	}

//  一般情况下用马，遇到大河的时候用船
//	TODO 编程思想：讲具体的要求封装在Person类中的方法中
	public void pasRiver() {
//		判断一下当前v的属性是否已经存在了，如果是空的，就获取一艘船
//		如何防止使用的始终是传入的马  instanceof
//		if(v == null) {
//		判断的是：1.TODO v空不空 2.v是不是船
		if(!(v instanceof Boat)){
//			多态 转型
			v = VehiclesFactory.getBoat();
		}
//		这里体现接口调用
		v.work();
	}

	public void pass() {
//		判断一下当前v的属性是否已经存在了，如果是空的，就获取一匹马
//		if(v == null) {
		if(!(v instanceof Horse)) {
//			多态 转型
			v = VehiclesFactory.getHorse();
		}
//		这里体现接口调用
		v.work();
	}

		public void passFire() {
		if(!(v instanceof Plane)) {
			v = VehiclesFactory.getPlane();
		}
		v.work();
	}
}