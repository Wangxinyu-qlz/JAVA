package creation_based.factory_method;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 14:42
 * @description:
 **/
//抽象工厂类
public abstract class Factory {
	abstract public Product manufacture();
}

//具体工厂类
class FactoryA extends Factory {
	@Override
	public Product manufacture() {
		return new ProductA();
	}
}

//具体工厂类
class FactoryB extends Factory {
	@Override
	public Product manufacture() {
		return new ProductB();
	}
}