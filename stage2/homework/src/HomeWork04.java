/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork04 {
	public static void main(String[] args) {
//		TODO 匿名内部类
		CellPhone cellphone = new CellPhone();
		cellphone.test(new ICalculate() {
			@Override
			public double calculate(double a, double b) {
				return a + b;
			}
		}, 1, 3.3);
	}
}

interface ICalculate {
	double calculate(double a, double b);
}

class CellPhone {
	public void test(ICalculate ic, double a, double b) {
		System.out.println(ic.calculate(a, b));
	}
}