package creation_based.prototype;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 16:07
 * @description:
 **/
public class ConcretePrototype extends Prototype{
	private String filed;

	public ConcretePrototype(String filed) {
		this.filed = filed;
	}

	@Override
	Prototype myClone() {
		return new ConcretePrototype(filed);
	}

	@Override
	public String toString() {
		return filed;
	}
}
