package creation_based.abstract_factory;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:26
 * @description:
 * 抽象工厂模式创建的是对象家族，也就是很多对象而不是一个对象，
 * 并且这些对象是相关的，也就是说必须一起创建出来。
 * 而工厂方法模式只是用于创建一个对象，这和抽象工厂模式有很大不同。
 **/
public class Client {
	public static void main(String[] args) {
		ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
		AbstractProductA productA = concreteFactory1.createProductA();
		AbstractProductB productB = concreteFactory1.createProductB();
		//...
	}
}
