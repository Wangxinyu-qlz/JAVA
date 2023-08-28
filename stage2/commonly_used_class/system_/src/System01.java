import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class System01 {
	public static void main(String[] args) {
		System.out.println("OK1");
//		0 代表正常退出
//		System.exit(0);
		System.out.println("OK2");

//		arrayCopy：复制数组元素，适合底层调用
//		一般使用Arrays.copyOf()完成数组复制

		int[] src = {1, 2, 3};
		int[] dest = new int[3];//dest当前是{0， 0， 0}

//      参数含义：
//		1.src           源数组
//		2.srcPos        源数组中开始的索引位置
//		3.dest          目标数组
//		4.destPos       目标数组的开始索引位置
//		5.length        拷贝的数组的长度
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(dest));//[1, 2, 3]

//		返回当前时间距离1970-1-1 的毫秒数
		System.out.println(System.currentTimeMillis());//1693235370110

//		long l = 6584651685465468746516846516518746516546541;//Error过大的整数
//		System.out.println("l=" = l);
		BigInteger bigInteger1 = new BigInteger("6584651685465468746516846516518746516546541");
		BigInteger bigInteger2 = new BigInteger("65846516854654");
		System.out.println(bigInteger1);
//		加
		BigInteger add = bigInteger1.add(bigInteger2);
		System.out.println(add);
//      减
		BigInteger sub = bigInteger1.subtract(bigInteger2);
		System.out.println(sub);
//      乘
		BigInteger multiply = bigInteger1.multiply(bigInteger2);
		System.out.println(multiply);

//		除
		BigInteger divide = bigInteger1.divide(bigInteger2);
		System.out.println(divide);


//      当需要保存一个精度很高的数时，double 不够用
		double d = 1.1111111111111111111111119999999999999999999999999999999999999d;
		System.out.println(d);//1.1111111111111112

		BigDecimal bigDecimal1 = new BigDecimal("1.1111111111111111111111119999999999999999999999999999999999999");
		System.out.println(bigDecimal1);
		BigDecimal bigDecimal2 = new BigDecimal("1.111111111111111111111111999999");

//		加减乘除使用 bigDecimal1.add/subtract/multiply/divide
//		TODO 调用divide时，指定精度
//		BigDecimal.ROUND_CEILING如果有无限循环小数，保留分子精度
		System.out.println(bigDecimal1.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
	}
}
