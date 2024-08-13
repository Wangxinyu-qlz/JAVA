package creation_based.abstract_factory;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:26
 * @description:
 **/
public class ConcreteFactory2 extends AbstractFactory{

	@Override
	AbstractProductA createProductA() {
		return new ProductA2();
	}

	@Override
	AbstractProductB createProductB() {
		return new ProductB2();
	}
}
