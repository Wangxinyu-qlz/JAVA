package creation_based.factory_method;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 14:46
 * @description:
 **/
//抽象产品类
public abstract class Product {
	public abstract void show();
}

//具体产品类
class ProductA extends Product{
	@Override
	public void show() {
		System.out.println("生产A");
	}
}
//具体产品类
class ProductB extends Product {
	@Override
	public void show() {
		System.out.println("生产B");
	}
}