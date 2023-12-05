import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] nums = new int[t];
		for(int i=0; i<t; i = i+1){//t组测试
			nums[i] = in.nextInt();
		}
		for(int i=0; i<t; i = i+1){
			if(nums[i] == 1){
				System.out.print(0);
				if(i<t-1) System.out.println();
			}
			if(nums[i]==2){
				System.out.print(1);
				if(i<t-1) System.out.println();
			}
			if(nums[i] > 2){
				int n = nums[i];
				int[] dp = new int[n];
				for(int m = 0; m<n; m++){
					dp[m] = 0;
				}
				dp[n/2] = n;
				int min = 1;
				int max = n-1;
				for(int j=1; j<=(n+1)/2 - 1; j=j+1){
					if(j%2==1){//第奇数次，放最小的
						dp[n/2-j] = min;
						min = min+1;
						dp[n/2+j] = min;
						min = min+1;
					}
					if(j%2==0){//第偶数次，放最大的
						dp[n/2-j] = max;
						max = max - 1;
						dp[n/2+j] = max;
						max = max - 1;
					}
				}
				if(n%2 == 0){//差一次
					dp[0] = min;
				}
				int sum = 0;
				for(int k=0; k<n-1; k++){
					sum += Math.abs(dp[k] - dp[k+1]);
				}
				System.out.print(sum);
				if(i<t-1) System.out.println();
			}
		}

	}
}
