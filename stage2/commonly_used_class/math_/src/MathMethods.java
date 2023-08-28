import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class MathMethods {
	public static void main(String[] args) {
		int abs = Math.abs(-9);
		System.out.println(abs);//9

//		TODO 注意返回的是double，参数列表也是double
		double pow = Math.pow(2, 4);
		System.out.println(pow);//16.0

		double ceil = Math.ceil(3.3);
		System.out.println(ceil);//4.0

		double floor = Math.floor(3.3);
		System.out.println(floor);//3.0

//		TODO 返回类型是 long
		long round = Math.round(3.14);
		System.out.println(round);//3

		double sqrt = Math.sqrt(4.0);
		System.out.println(sqrt);//2.0

//		TODO 返回类型是 double  范围：[0,1)
		double random = Math.random();//[0,1)
		System.out.println(random);
//		返回特定范围的随机数 (a, b)
		double min = 1;
		double max = 5;
		for (int i = 0; i < 300; i++) {
			System.out.println(Math.random() * (max - min) + min);//[min, max)小数
		}

		for (int i = 0; i < 300; i++) {
			System.out.println((int)(Math.random() * (max - min + 1) + min));//[min, max]整数
		}

		int m = Math.min(1, 3);//只能有两个参数

	}
}
