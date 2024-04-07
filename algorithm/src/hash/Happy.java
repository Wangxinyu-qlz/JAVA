package hash;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-06 16:09
 * @description:
 **/
public class Happy {
	public static void main(String[] args) {
		int n = 19;
		System.out.println(isHappy(n));
	}
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (n!=1 && !set.contains(n)) {
			set.add(n);
			n = getSum(n);
		}
		return n==1;
	}

	public static int getSum(int n) {
		int sum = 0;
		while (n>0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}
}
