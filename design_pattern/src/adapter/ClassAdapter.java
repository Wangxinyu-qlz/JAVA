package adapter;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:07
 * @description:
 * 结构型设计模式
 *
 * 把一个类的接口变换成客户端所期待的另一种接口，
 * 从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 * 如：插座转换器
 * 优点
 *      更好的复用性：系统需要使用现有的类，而此类的接口不符合系统的需要。
 *      那么通过适配器模式就可以让这些功能得到更好的复用。
 *      更好的扩展性：在实现适配器功能的时候，可以扩展自己源的行为（增加方法），
 *      从而自然地扩展系统的功能。
 * 缺点
 *      会导致系统紊乱：滥用适配器，会让系统变得非常零乱。
 *      例如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，
 *      一个系统如果太多出现这种情况，无异于一场灾难。
 *      因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 **/
public class ClassAdapter extends Adaptee implements Target{
	@Override
	public void m2() {
		System.out.println("m2");
	}
}

class ObjectAdapter implements Target {
	private Adaptee adaptee;
	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void m1() {
		adaptee.m1();
	}

	@Override
	public void m2() {
		System.out.println("m2");
	}
}

class AdapterTest {
	public static void main(String[] args) {
		//类适配器
		ClassAdapter classAdapter = new ClassAdapter();
		classAdapter.m1();
		classAdapter.m2();

		//对象适配器
		ObjectAdapter objectAdapter = new ObjectAdapter(new Adaptee());
		objectAdapter.m1();
		objectAdapter.m2();

		//接口（缺省）适配器
		//	为一个接口提供缺省实现，这样子类可以从这个缺省实现进行扩展，
		//	而不必从原有接口进行扩展。
		//  可以看到其实我们只使用到其中一个方法，
		//  但必须要把接口中所有方法都实现一遍，
		//  如果接口里方法非常多，那岂不是非常麻烦。
		//  于是引入一个默认适配器，让适配器把接口里的方法都实现一遍，
		//  使用时继承这个适配器，把需要的方法实现一遍就好了。
	}
}
