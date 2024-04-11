package dp;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-10 09:13
 * @description:
 **/
public class Fib {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		if(n==0) return 0;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];

	}
}
