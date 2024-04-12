package dp;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-12 10:01
 * @description:
 **/
public class CanPartition {
	public static void main(String[] args) {
		int[] nums = {3, 3, 3, 4, 5};
		System.out.println(canPartition(nums));
	}


	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		int[][] dp = new int[n][target + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= target; j++) {
				dp[i][j] = 0;
			}
		}
		//TODO 注意这里的初始化，最好打表
		for (int j = 0; j <= target; j++) {
			if (j >= nums[0]) {
				dp[0][j] = nums[0];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= target; j++) {
				if (j < nums[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
				}
			}
		}
		if (dp[n - 1][target] == target) {
			return true;
		}
		return false;
	}
}
