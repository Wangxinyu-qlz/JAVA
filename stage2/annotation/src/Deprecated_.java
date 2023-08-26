/**
 * @author qiaolezi
 * @version 1.0
 */
public class Deprecated_ {
	public static void main(String[] args) {
		A a = new A();
		a.hi();
	}
}

//@Deprecated修饰一个类表示一个类过时了
//不推荐使用，但是仍然可以使用
//可以修饰：类 字段 包 参数 等等
//可以做版本升级过渡使用
@Deprecated
class A {
	public int n1 = 10;
	@Deprecated
	public void hi() {
		System.out.println("hi");
	}
}
