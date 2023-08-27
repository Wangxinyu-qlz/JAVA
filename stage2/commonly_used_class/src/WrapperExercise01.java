/**
 * @author qiaolezi
 * @version 1.0
 */
public class WrapperExercise01 {
	public static void main(String[] args) {
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j);//false new的两个对象

//		TODO 阅读源码
		/*
		* IntegerCache.low=-128  IntegerCache.high=127
		*public static Integer valueOf(int i) {
		* if (i >= IntegerCache.low && i <= IntegerCache.high)
		*   return IntegerCache.cache[i + (-IntegerCache.low)];
		* return new Integer(i);
		* }
		* */
//		如果范围在[-128,127]，不new --> m==n true
		Integer m = 1;
		Integer n  =1;
		System.out.println(m == n);//true

//		范围不在[-128,127]，new --> x==y false
		Integer x = 128;
		Integer y = 128;
		System.out.println(x == y);//false
	}
}

