package dp;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-11 15:12
 * @description:
 **/
public class BackPack0_1 {
	public static void main(String[] args) {
		int[] weight = {1, 3, 4};
		int[] value = {15, 20, 30};
		int bag_weight = 4;
		int n = weight.length;
		//TODO dp[i][j]：从0-i号物品中任意取物品，放在背包容量为j的背包中，价值总和为dp[i][j]
		//TODO n:物品0- n-1
		// bag_weight+1:容量为0 - bag_weight
		int[][] dp = new int[n][bag_weight+1];

		//dp数组的初始化
		for(int i=0; i<n; i++){
			for(int j=0; j<bag_weight; j++) {
				dp[i][j] = 0;
			}
		}
		//TODO 初始化为背包的重量
		// dp[i][j]是由左上角的数据推算出来的
		/*0 15 15 15 15
		  0 0  0  0  0
		  0 0  0  0  0*/
		for(int j=1; j<bag_weight; j++) {
			dp[0][j] = weight[0];
		}

		for(int i=1; i<n; i++) {//遍历物品
			for(int j = 0; j<=bag_weight; j++) {//遍历背包重量
				//用来判断当前物品（索引为 i）能否在背包容量为 j 的情况下放入背包中
				//第 i 个物品的重量超过了当前可用的背包容量 j，因此无法将第 i 个物品放入背包中。
				//dp[i][j]将等于 dp[i-1][j]（使用前 i-1 个物品和相同容量 j 可达到的最大价值）
				if(j < weight[i]) {  //TODO 如何理解
					dp[i][j] = dp[i-1][j];
				//j >= weight[i]，则我们有两个选择：
				//选择 1： 不包含第 i 个物品。
				//选择 2： 包含第 i 个物品。
				//将第 i 个物品的价值 (value[i]) 加到包含第 i 个物品后剩余容量所能达到的最大价值上 (j - weight[i])
				//第i个物品的价值为value[i]，重量为weight[i]，-->dp[i-1][j-weight[i]] + value[i]
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
				}
			}
		}

		System.out.println(dp[n-1][bag_weight]);

	}
}
