package creation_based.factory_method;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 14:57
 * @description:
 **/
//调用方
public class FactoryPattern {
	public static void main(String[] args) {
		FactoryA factoryA = new FactoryA();
		factoryA.manufacture().show();

		FactoryB factoryB = new FactoryB();
		factoryB.manufacture().show();
	}
}
