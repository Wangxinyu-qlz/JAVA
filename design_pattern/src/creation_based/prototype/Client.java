package creation_based.prototype;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 16:08
 * @description:
 * 使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象。
 **/
public class Client {
	public static void main(String[] args) {
		ConcretePrototype prototype = new ConcretePrototype("abc");
		Prototype clone = prototype.myClone();
		System.out.println(clone.toString());
	}
}
