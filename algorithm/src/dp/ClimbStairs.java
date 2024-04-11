package dp;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-11 09:02
 * @description:
 **/
public class ClimbStairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] dp = new int[n + 5];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[n]);
	}
}
