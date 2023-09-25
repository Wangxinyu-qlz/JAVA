/**
 * @author qiaolezi
 * @version 1.0
 */
public class CustomGeneric {
	public static void main(String[] args) {

	}
}

//1.Tiger 后面有泛型 ->Tiger为自定义泛型类
//2.R M T 是泛型的标识符
//3.泛型的标识符可以有多个
//4.普通成员可以使用泛型（属性、方法）
//5.使用泛型的数组，不能进行初始化
class Tiger<T, R, M> {
	String name;
	R r;//属性使用泛型
	M m;
	T t;

//	数组在new时 类型T不确定，无法在内存开辟空间
//	T[] ts = new T[8];//Type parameter 'T' cannot be instantiated directly
	T[] ts;

	public Tiger(String name, R r, M m, T t) {//构造器使用泛型
		this.name = name;
		this.r = r;
		this.m = m;
		this.t = t;
	}

//	静态方法和类相关，在类加载时，对象还没有创建
//	所以如果静态方法和属性使用泛型，JVM无法完成初始化
//	static R r2;
//	public static void m1(M m) {}//'Tiger.this' cannot be referenced from a static context

	public R getR() {//方法使用泛型
		return r;//返回类型使用泛型
	}

	public void setR(R r) {
		this.r = r;
	}
}