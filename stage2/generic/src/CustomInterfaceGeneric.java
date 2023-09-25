/**
 * @author qiaolezi
 * @version 1.0
 */
public class CustomInterfaceGeneric {
	public static void main(String[] args) {

	}

}

//1.在接口中，静态成员不能使用泛型
//2.
interface IUsb<U, R> {
	int n = 0;
//	U name;//Error:'IUsb.this' cannot be referenced from a static context

	R get(U u);
	void hi(R r);
	void run(R r1, R r2, U u1, U u2);

//	在JDK8中，可以在接口中使用默认方法，可以使用泛型
	default R method(U u) {
		return null;
	}
}

//没有指定类型时，默认为Object类型
//不建议这么写
class CC implements IUsb {//等价于 class CC implements IUsb<Object, Object>{...}

	@Override
	public Object get(Object o) {
		return null;
	}

	@Override
	public void hi(Object o) {

	}

	@Override
	public void run(Object r1, Object r2, Object u1, Object u2) {

	}
}

interface IA extends IUsb<String, Double> {

}

//实现接口时，直接指定接口的类型
class BB implements IUsb<Integer, Float> {

	@Override
	public Float get(Integer integer) {
		return null;
	}

	@Override
	public void hi(Float aFloat) {

	}

	@Override
	public void run(Float r1, Float r2, Integer u1, Integer u2) {

	}
}
//实现IA接口时，IA在实现IUsb接口时，指定了<U, R>为<String, Double>
//在实现IUsb接口的方法时，使用String替换U，使用Double替换R
class AA implements IA {
	public AA() {
	}

	@Override
	public Double get(String s) {
		return null;
	}

	@Override
	public void hi(Double aDouble) {

	}

	@Override
	public void run(Double r1, Double r2, String u1, String u2) {

	}

	@Override
	public Double method(String s) {
		return IA.super.method(s);
	}
}
