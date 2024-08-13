package creation_based.simple_factory;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 14:34
 * @description:
 * 它把实例化的操作单独放到一个类中，这个类就成为简单工厂类，
 * 让简单工厂类来决定应该用哪个具体子类来实例化，
 * 这样做能把客户类和具体子类的实现解耦，
 * 客户类不再需要知道有哪些子类以及应当实例化哪个子类。
 **/
public class SimpleFactory {
	public Product createProduct(int type) {
		if(type == 1) {
			return new ConcreteProduct1();
		} else if(type == 2) {
			return new ConcreteProduct2();
		}
		return new ConcreteProduct();
	}
}

class Client {
	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		Product product = simpleFactory.createProduct(1);
		//...
	}
}

