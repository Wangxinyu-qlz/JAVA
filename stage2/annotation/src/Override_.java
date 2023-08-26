/**
 * @author qiaolezi
 * @version 1.0
 */
public class Override_ {
	public static void main(String[] args) {

	}
}

class Father {
	public void hi() {
		System.out.println("Father.");
	}
}

class Son extends Father {
//	如果写了 @override 注解 ，编译器会检查子类是否 真正重写了 父类的方法
//	如果没有重写，编译器报错
	@Override
	public void hi() {
		System.out.println("Son.");
	}
}
