package creation_based.abstract_factory;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 15:25
 * @description:
 **/
public class ConcreteFactory1 extends AbstractFactory{
	@Override
	AbstractProductA createProductA() {
		return new ProductA1();
	}

	@Override
	AbstractProductB createProductB() {
		return new ProductB1();
	}
}
