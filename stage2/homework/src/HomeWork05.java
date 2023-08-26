/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork05 {
	public static void main(String[] args) {
		A a = new A();
		a.f();
	}
}

class A {
	private String name = "wang";
	public void f() {
		class B {
			private final String name = "li";
			public void show() {
				System.out.println(name);
				System.out.println(A.this.name);
			}
		}

		B b = new B();
		b.show();
	}
}
